getFactBtn.addEventListener("click", async () => {
  const facts = await fetchFacts(1);
  if (facts) {
    displayFacts(facts[0]);
  }
});

getMultipleBtn.addEventListener("click", async () => {
  const count = parseInt(factCount.value) || 1;

  if (count < 1 || count > 5) {
    return;
  }

  try {
    showLoading();
    const facts = await fetchFacts(count);
    if (facts) {
      displayMultipleFacts(facts);
    }
  } catch (err) {
    showError(err.message);
  } finally {
    hideLoading();
  }
});
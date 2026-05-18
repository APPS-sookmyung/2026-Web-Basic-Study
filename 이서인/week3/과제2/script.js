const factArea = document.getElementById("factArea");
const getFactBtn = document.getElementById("getFactBtn");

getFactBtn.addEventListener("click", async () => {
    try {
        factArea.innerText = "Loading...";
        const response = await fetch("https://catfact.ninja/fact");
        const data = await response.json();
        factArea.innerText = data.fact;
    } catch (error) {
        factArea.innerText = "고양이 정보를 불러오는 데 실패했습니다.";
        console.error(error);
    }
});
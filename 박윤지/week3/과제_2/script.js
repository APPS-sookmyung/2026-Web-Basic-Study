const languageSelect = document.getElementById("language");
const getFactBtn = document.getElementById("getFactBtn");
const getMultipleBtn = document.getElementById("getMultipleBtn");
const factCount = document.getElementById("factCount");
const factContainer = document.getElementById("factContainer");
const loading = document.getElementById("loading");
const error = document.getElementById("error");

const API_URL = "https://meowfacts.herokuapp.com";

function showLoading() {
  // classList : loading 요소의 class 속성을 가져온다
  // class 속성 초기 상태 : "hidden"
  loading.classList.remove("hidden");
}

function hideLoading() {
  loading.classList.add("hidden");
}

function showError(message) {
  // textContent: 요소의 모든 텍스트 콘텐츠 (script, style 태그의 내용도 포함)
  error.textContent = message;
  error.classList.remove("hidden");
  setTimeout(() => error.classList.add("hidden"), 3000);
}

function displayFacts(facts) {
  // innerHTML : 요소 내의 모든 HTML
  // cf. innerText : 사용자가 볼 수 있는 텍스트값
  factContainer.innerHTML = "";
  // facts 가 배열이면 그대로, 아니면 배열로 만듦
  const factsArray = Array.isArray(facts) ? facts : [facts];
  // forEach : 인자로 전달된 함수를 배열 요소 각각에 대해 실행
  factsArray.forEach((fact, index) => {
    // document 객체에 div 태그 요소 추가 후 factCard 변수에 할당
    const factCard = document.createElement("div");
    factCard.className = "fact-card";
    
    if (factsArray.length > 1) {
      // ${} : 문자열 포맷팅을 하는 자바스크립트식 표현 (서식지정자와 유사한 역할)
      factCard.textContent = `${index + 1}. ${fact}`;
    } else {
      factCard.textContent = fact;
    }

    // factContainer에 factcard를 자식요소로 추가
    factContainer.appendChild(factCard);
  });
}


async function fetchFacts(count = 1) {
  const lang = languageSelect.value;
  const url = `${API_URL}/?count=${count}&lang=${lang}`;
  try {
    showLoading();
    // fetch(API_URL) : 자바스크립트에서 네트워크 요청을 보낼 때 사용
    const response = await fetch(url);
    // .json : 받은 응답을 JSON 형식으로 변환
    const data = await response.json();
    return data.data    // data.data 배열
  } catch (err) {
    showError("Failed to fetch cat facts");
  } finally {
    hideLoading();
  }
}


getFactBtn.addEventListener("click", async () => {
  const facts = await fetchFacts(1);    // 하나의 고양이 사실 가져오기
  //  facts && : facts가 null 인지 확인
  if (facts && facts.length > 0)
    displayFacts(facts[0]);
});

getMultipleBtn.addEventListener("click", async () => {
  //  parseInt : 문자열 인자 파싱 후, 특정 진수(생략 시 10진수)의 정수 반환
  
  const count = parseInt(factCount.value);
  if (count < 1 || count > 5){
    showError("Please enter a number between 1 and 5");
    return;
  }
  const facts = await fetchFacts(count);
  //  facts && : facts가 null 인지 확인
  if (facts && facts.length > 0)
    displayFacts(facts);
});

// 페이지 로드시 자동으로 하나의 고양이 사실 가져오기
window.addEventListener("load", () => {
  getFactBtn.click();
});

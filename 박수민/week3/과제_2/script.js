// DOM 요소 선택
const languageSelect = document.getElementById("language");
const getFactBtn = document.getElementById("getFactBtn");
const getMultipleBtn = document.getElementById("getMultipleBtn");
const factCount = document.getElementById("factCount");
const factContainer = document.getElementById("factContainer");
const loading = document.getElementById("loading");
const error = document.getElementById("error");

// API URL
const API_URL = "https://meowfacts.herokuapp.com";

// 유틸리티 함수들
function showLoading() {
  loading.classList.remove("hidden"); // 로딩 메시지 표시
}

function hideLoading() {
  loading.classList.add("hidden"); // 로딩 메시지 숨김
}

function showError(message) {
  error.textContent = message; // 에러 메시지 설정
  error.classList.remove("hidden"); // 에러 메시지 표시
  setTimeout(() => error.classList.add("hidden"), 3000); // 3초 후 자동으로 숨김
}

function displayFacts(facts) {
  factContainer.innerHTML = ""; // 기존 내용을 비우기

  // 전달된 데이터가 단일 문자열일 수도 있으므로 배열로 변환
  const factsArray = Array.isArray(facts) ? facts : [facts];

  factsArray.forEach((fact, index) => {
    const factCard = document.createElement("div");
    factCard.className = "fact-card";

    // 만약 여러 개의 팩트가 있다면 번호를 붙여서 표시
    if (factsArray.length > 1) {
      factCard.textContent = `${index + 1}. ${fact}`;
    } else {
      factCard.textContent = fact;
    }

    factContainer.appendChild(factCard); // 생성한 요소를 factContainer에 추가
  });
}

// #1: API 호출 함수 구현 (비동기 처리 + fetch 사용)
async function fetchFacts(count = 1) {
  //  1. 사용자가 선택한 언어(language) 가져오기
  const lang = document.getElementById("language").value;
  //  2. API 요청 URL 생성!!!! 힌트: const url='$_?_= $_&_=$_'
  const url = `https://meowfacts.herokuapp.com/?count=${count}&lang={lang}`;

  try {
    //  3. 로딩 상태 표시
    showLoading();
    const response = await fetch(url);
    /* HTTP 상태 코드를 체크하여 응답이 정상인지 확인. →  성공하면  응답을 JSON 형식으로 변환하여 데이터 반환. 
    if 응답 없을 시 에러 발생 메세지 작성 "Failed to fetch cat facts" */
    if (!response.ok) {
        throw new Error("Failed to fetch cat facts");
    }
    const data = await response.json();
    return data.data;

  } catch (err) {
    showError(err.message);
}

/* #2: 이벤트 리스너 추가 (버튼 클릭 시 API 요청 및 결과 표시)
- 버튼 클릭 시 `fetchFacts()` 호출하여 데이터 가져오기
- 단일 fact는 `displayFacts(facts[0])`을 사용해 표시*/
getFactBtn.addEventListener("click", async () => {
  const facts = await fetchFacts(1);
  if (facts && facts.length > 0) {
    displayFacts(facts[0]);
  }
});

//   #3: 여러 개의 팩트를 가져오는 버튼 처리
getMultipleBtn.addEventListener("click", async () => {
  const count = parseInt(factCount.value) || 1;
  if (count <1 || count > 5) {
    showError("Please enter a number between 1 and 5");
    return;
  }
  const facts = await fetchFacts(count);
  if (facts && facts.length > 0) {
    displayFacts(facts);
  }
});

// 페이지 로드시 자동으로 하나의 고양이 사실 가져오기
window.addEventListener("load", () => {
  getFactBtn.click();
});
}
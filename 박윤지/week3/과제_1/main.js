// document 객체 : HTML 문서를 트리구조로 객체화 한것 (DOM)
document.addEventListener("DOMContentLoaded", function () {
  // querySelector : 지정한 선택자와 일치하는 첫 번째 요소 객체 반환
  // input 태그 중 name 속성이 output인 요소 선택
  const output = document.querySelector("input[name='output']");

  // keydown : 사용자가 키보드의 키를 누르는 순간 발생하는 이벤트
  // addEventListener (이벤트 타입, 실행할 함수)
  // 이벤트 타입: click, scroll, submit 등...
  // 실항할 함수: 발생한 이벤트에 대한 상세 정보가 담긴 이벤트 객체를 첫 번째 매개변수로 전달 받음
  document.addEventListener("keydown", function (event) {
    // value : output의 value 속성이 객체화된 것! (문자열)
    // slice(begin[, end])
    const lastChar = output.value.slice(-1);

    if (event.key >= "0" && event.key <= "9") {
      output.value += event.key;
    }

    // ["+", "-", "*", "/"] 배열에 event로 받은 key가 포함되어 있는지
    if (["+", "-", "*", "/"].includes(event.key)) {
      if (output.value === "" || ["+", "-", "*", "/"].includes(lastChar)) {
        return;
      }
      output.value += event.key;
    }

    if (event.key === ".") {
      // 첫 입력 소수점, 소수점 연속 입력, 마지막 숫자에 이미 소수점이 포함된 경우 제외
      if (
        output.value === "" ||
        lastChar === "." ||
        output.value
          .split(/[\+\-\*\/]/)
          .pop()
          .includes(".")
      ) {
        return;
      }
      output.value += event.key;
    }

    if (event.key === "Enter") {
      try {
        // eval : 문자열로 된 코드를 인자로 받아, 식이면 값 생성, 문이면 코드 실행
        output.value = eval(output.value);
      } catch (error) {
        output.value = "Error";
      }
    }

    // (0,-1) : 0 번째부터 -1 인덱스 직전까지
    if (event.key === "Backspace") {
      output.value = output.value.slice(0, -1);
    }
    if (event.key === "Escape") {
      output.value = "";
    }

    // 브라우저에 대해 모든 키의 동작 막기
    event.preventDefault();
  });
});
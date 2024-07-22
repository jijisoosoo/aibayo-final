const chatInput = document.querySelector(".chat-input textarea")
const sendChatBtn = document.querySelector(".chat-input span")
const chatbox = document.querySelector(".chatbox")
const chatbotToggler = document.querySelector(".chatbot-toggler")


let userMessage;
const inputInitHeight = chatInput.scrollHeight;

const createChatLi = (message, className) => {
    const chatLi = document.createElement("li");
    chatLi.classList.add("chat", className);
    let chatContent =  className === "outgoing" ? '<p></p>' : '<span class="material-symbols-outlined">Person</span><p></p>';
    chatLi.innerHTML = chatContent;
    chatLi.querySelector("p").textContent = message;
    return chatLi;
}

const handleChat = () => {
    userMessage = chatInput.value.trim();
    if (!userMessage) return;

    chatInput.style.height = `${inputInitHeight}px`; // 채팅 보내면 채팅 입력창 높이 초기화


    // 작성한 채팅 생성
    chatbox.appendChild(createChatLi(userMessage, "outgoing"));

    // 채팅치면 textarea 태그에 있는 작성글 사라지게
    chatInput.value = "";

    // 채팅창 스크롤
    chatbox.scrollTo(0, chatbox.scrollHeight);


    // setTimeout(() => {
    //     // display "생각중.." message while waiting for the response
    //     chatbox.appendChild(createChatLi("생각 중...", "incoming"));
    // }, 600);
}

chatInput.addEventListener("input", () => {
    // 채팅 입력창 크기 조절
    chatInput.style.height = `${inputInitHeight}px`;
    chatInput.style.height = `${chatInput.scrollHeight}px`;
});

chatInput.addEventListener("keydown", (e) => {
    // enter 키 누르면 전송, shift+enter 키 누르면 줄 바꿈
    if (e.key === "Enter" && !e.shiftKey && window.innerWidth > 800) {
        e.preventDefault();
        handleChat();
    }

});


sendChatBtn.addEventListener("click", handleChat);
chatbotToggler.addEventListener("click", () => document.body.classList.toggle("show-chatbot"));

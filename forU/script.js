let currentCard = 0;
const cards = document.querySelectorAll('.card');
const flipbook = document.querySelector('.flipbook');

function updateFlipbookPosition() {
  flipbook.style.transform = `translateX(-${currentCard * 300}px)`;
}

function nextCard() {
  if (currentCard < cards.length - 1) {
    currentCard++;
    updateFlipbookPosition();
  }
}

function prevCard() {
  if (currentCard > 0) {
    currentCard--;
    updateFlipbookPosition();
  }
}

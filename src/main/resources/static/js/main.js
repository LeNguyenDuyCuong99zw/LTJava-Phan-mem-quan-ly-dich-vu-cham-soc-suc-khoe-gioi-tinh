// Dropdown toggle logic cho desktop
const dropdownWrap = document.getElementById("dropdownWrap");
const dropdownBtn = document.getElementById("dropdownBtn");
document.addEventListener("click", function (e) {
  if (dropdownWrap.contains(e.target)) {
    dropdownWrap.classList.toggle("active");
  } else {
    dropdownWrap.classList.remove("active");
  }
});

// Hamburger menu logic
const menuIcon = document.getElementById("menuIcon");
const sideMenu = document.getElementById("sideMenu");
const closeMenu = document.getElementById("closeMenu");
const overlay = document.getElementById("sideMenuOverlay");
menuIcon.onclick = () => {
  sideMenu.classList.add("open");
  overlay.style.display = "block";
};
closeMenu.onclick = () => {
  sideMenu.classList.remove("open");
  overlay.style.display = "none";
};
overlay.onclick = () => {
  sideMenu.classList.remove("open");
  overlay.style.display = "none";
};

// Dropdown in side menu (mobile)
const dropdownBtnMobile = document.getElementById("dropdownBtnMobile");
const dropdownContentMobile = document.getElementById("dropdownContentMobile");
dropdownBtnMobile.onclick = function (e) {
  e.preventDefault();
  dropdownBtnMobile.classList.toggle("active");
  dropdownContentMobile.style.display =
    dropdownContentMobile.style.display === "flex" ? "none" : "flex";
};
// Đóng dropdown khi click ra ngoài (mobile)
document.addEventListener("click", function (e) {
  if (!sideMenu.contains(e.target) && !menuIcon.contains(e.target)) {
    sideMenu.classList.remove("open");
    overlay.style.display = "none";
  }
  if (
    !dropdownBtnMobile.contains(e.target) &&
    !dropdownContentMobile.contains(e.target)
  ) {
    dropdownBtnMobile.classList.remove("active");
    dropdownContentMobile.style.display = "none";
  }
});
// Ngăn sự kiện click trong menu không đóng menu
sideMenu.onclick = function (e) {
  e.stopPropagation();
};

// Slider logic for banner images: shows pairs 1&2, 2&3, 3&1 in sequence
const slider = document.getElementById("ivieBannerSlider");
const imgs = slider.querySelectorAll(".ivie-banner-img");
const dots = document.querySelectorAll(".dot");
const pairs = [
  [0, 1],
  [1, 2],
  [2, 0],
];
let pairIdx = 0;
let intervalId;

function showPair(idx) {
  imgs.forEach((img, i) => {
    img.style.display = pairs[idx].includes(i) ? "block" : "none";
  });
  dots.forEach((dot, i) => {
    dot.classList.toggle("active", i === idx);
  });
  pairIdx = idx;
}

function startSlider() {
  intervalId = setInterval(() => {
    let next = (pairIdx + 1) % pairs.length;
    showPair(next);
  }, 2500);
}

dots.forEach((dot, i) => {
  dot.addEventListener("click", () => {
    clearInterval(intervalId);
    showPair(i);
    startSlider();
  });
});

showPair(0);
startSlider();

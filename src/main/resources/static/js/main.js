//Navigation
const toggle = document.querySelector(".toggle");
const navigation = document.querySelector(".navigation");
const combo = document.querySelectorAll(".combo li a");
const subnav = document.querySelector(".subnav");

toggle.onclick = function () {
    toggle.classList.toggle('active');
    navigation.classList.toggle('active');
    subnav.classList.remove("active");
}



for (let i = 0; i < combo.length; i++) {
    combo[i].addEventListener("click", function () {
        let menu = ['Galeria', 'Acessorios', 'Financie', 'Contato', '']
        if (combo[i].textContent.trim() == 'Motos') {
            subnav.classList.add("active");
        } else if (menu.includes(combo[i].textContent.trim())) {
            subnav.classList.remove("active");
        } else {
            console.log(combo[i].textContent.trim())
            subnav.classList.toggle("active");
        }
    });
}


// combo.onclick = function () {
//     subnav.classList.toggle('active');
// }

// item.onclick = function () {
//     subnav.classList.toggle('active');
// }

//slider
const slides = document.querySelectorAll(".slides");
const dots = document.querySelectorAll(".dot");

function setActive(i) {
    for (slide of slides) {
        slide.classList.remove("active");
        slides[i].classList.add("active");
    }
    for (dot of dots) {
        dot.classList.remove("active");
        dots[i].classList.add("active");
    }
}

for (let d = 0; d < dots.length; d++) {
    dots[d].addEventListener("click", function () {
        subnav.classList.remove("active");
        setActive(d);
    });
}


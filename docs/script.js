const listItems = document.querySelectorAll('#key-features li');

listItems.forEach(item => {
    item.addEventListener('mouseenter', () => {
        item.style.backgroundColor = '#f0f0f0';
        item.querySelector('.feature-description').style.display = 'block';
    });

    item.addEventListener('mouseleave', () => {
        item.style.backgroundColor = '';
        item.querySelector('.feature-description').style.display = 'none';
    });
});

const sections = document.querySelectorAll('.container > img, .container > *'); // Target image and direct children of container
let delay = 0.3;

sections.forEach(section => {
   section.style.opacity = 0; // Add opacity for fade-in
   section.style.animation = 'fadeIn 1s ease-in forwards'; 
   section.style.animationDelay = delay + 's';
   delay += 0.2; 
});

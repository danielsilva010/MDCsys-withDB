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

const sections = document.querySelectorAll('.container > section, .container > h2, .container p');
let delay = 0.3; // Initial delay

sections.forEach(section => {
    section.style.animationDelay = delay + 's';
    delay += 0.2; // Increment delay for each section
});

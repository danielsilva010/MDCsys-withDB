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

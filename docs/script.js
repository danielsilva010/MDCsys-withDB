const keyFeaturesList = document.getElementById('key-features');

window.onload = function() {
  keyFeaturesList.style.opacity = 0; // Initially hide the list

  // Animation function to gradually show the list
  const animateList = () => {
    let opacity = 0;
    const intervalId = setInterval(() => {
      opacity += 0.1;
      keyFeaturesList.style.opacity = opacity;
      if (opacity >= 1) {
        clearInterval(intervalId);
      }
    }, 20); // Adjust the interval for animation speed (lower for faster)
  };

  animateList();
};

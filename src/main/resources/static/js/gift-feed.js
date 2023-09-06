const addGiftButton = document.getElementById("add-gift-button");
const popup = document.getElementById("popup");
const closePopupButton = document.getElementById("close-popup");
const giftForm = document.getElementById("gift-form");

addGiftButton.addEventListener("click", () => {
    popup.style.display = "flex";
    document.body.classList.add("popup-open"); // Add class to body to apply backdrop filter
    document.body.style.overflow = "hidden"; // Prevent scrolling
});

closePopupButton.addEventListener("click", () => {
    popup.style.display = "none";
    document.body.classList.remove("popup-open"); // Remove class to remove backdrop filter
    document.body.style.overflow = "auto"; // Enable scrolling
    giftForm.reset(); // Reset the form when closing the popup
});

giftForm.addEventListener("submit", (e) => {
    e.preventDefault(); // Prevent the form from submitting normally

    // Collect form data
    const formData = new FormData(giftForm);
    const giftName = formData.get("gift-name");
    const giftDescription = formData.get("gift-description");
    const giftImage = formData.get("gift-image");

    // You can now process the form data as needed, for example, send it to a server using fetch()

    // Close the popup after processing
    popup.style.display = "none";
    document.body.classList.remove("popup-open");
    document.body.style.overflow = "auto";
    giftForm.reset();
});

const fileInput = document.getElementById('gift-images');

// Add an event listener to check the number of selected files
fileInput.addEventListener('change', function () {
    const selectedFiles = this.files;
    if (selectedFiles.length < 3) {
        alert('Please select at least three images.');
        // Reset the file input to clear invalid selections
        this.value = '';
    }
});
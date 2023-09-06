const addGiftButton = document.getElementById("add-gift-button");
const popup = document.getElementById("popup");
const closePopupButton = document.getElementById("close-popup");
const giftForm = document.getElementById("gift-form");
const fileInput = document.getElementById("fileInput");
const uploadedFilesContainer = document.getElementById("uploaded-files-container");


addGiftButton.addEventListener("click", () => {
    popup.style.display = "flex";
    document.body.classList.add("popup-open");
    document.body.style.overflow = "hidden";
});

closePopupButton.addEventListener("click", () => {
    popup.style.display = "none";
    document.body.classList.remove("popup-open");
    document.body.style.overflow = "auto";
    giftForm.reset();
});

fileInput.addEventListener("change", () => {
    const files = fileInput.files;

    for (const file of files) {
        const fileItem = document.createElement("div");
        const fileName = file.name;

        // Create a new file item with a delete button
        fileItem.innerHTML = `
            <span>${fileName}</span>
            <button class="delete-file" data-file-name="${fileName}">X</button>
        `;

        uploadedFilesContainer.appendChild(fileItem);

        const deleteButton = fileItem.querySelector(".delete-file");
        deleteButton.addEventListener("click", () => {
            uploadedFilesContainer.removeChild(fileItem);
            const newFiles = Array.from(fileInput.files).filter((f) => f.name !== fileName);
            fileInput.files = new FileList({ length: newFiles.length, item: (index) => newFiles[index] });
        });
    }
});

giftForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const formData = new FormData(giftForm);

    try {
        const response = await fetch('/api/v1/gifts', {
            method: 'POST',
            body: formData,
        });

        if (response.ok) {
            console.log('Gift created successfully');
            clearUploadedFiles();
            closePopup();
        } else {
            console.error('Failed to create gift');
        }
    } catch (error) {
        console.error('An error occurred:', error);
    }
});

function clearUploadedFiles() {
    while (uploadedFilesContainer.firstChild) {
        uploadedFilesContainer.removeChild(uploadedFilesContainer.firstChild);
    }
    fileInput.value = "";
}

function closePopup() {
    popup.style.display = "none";
    document.body.classList.remove("popup-open");
    document.body.style.overflow = "auto";
    giftForm.reset();
}
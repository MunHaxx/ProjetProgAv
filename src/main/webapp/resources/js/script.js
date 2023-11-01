function changeClass(clickedDiv) {
    // Trouver la div suivante
    var nextDiv = clickedDiv.nextElementSibling;
    
    if (nextDiv && nextDiv.classList.contains("container-listes")) {
        if (nextDiv.classList.contains("hide")) {
            nextDiv.classList.remove("hide");
        } else {
            nextDiv.classList.add("hide");
        }
    }
}
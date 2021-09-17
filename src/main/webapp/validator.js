document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("button").addEventListener("click", submit);
    const canvas = document.querySelector('canvas')
    canvas.addEventListener('click', function (e) {
        handleCanvasClick(canvas, e)
    })
});

let submit = function (e) {
    if (document.getElementById("X_field").value.length === "" || document.getElementById("Y_field").value === "") {
        if (!checkY()) {
            e.preventDefault();
        } else {
            document.getElementById("X_field").value = document.getElementById("X").value
            document.getElementById("R_field").value = document.getElementById("R").value
            document.getElementById("Y_field").value = document.getElementById("y").value
                .trim().replace(',', '.').substr(0, 12);
        }
    }
}

function checkY() {
    let y = document.getElementById("y");
    y.value = y.value.trim().substr(0, 12);
    if (y.value.trim() === "") {
        alert("You must select the Y!");
        return false;
    }
    if (!isFinite(y.value.replace(',', '.'))) {
        alert("Y must be a number!");
        return false;
    }
    if (y.value.replace(',', '.') >= 5 || y.value.replace(',', '.') <= -5) {
        alert("Y must be in range (-5; 5)");
        return false;
    }
    return true;
}

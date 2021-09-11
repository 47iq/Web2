let selectedCheckbox;
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
        } else if (!checkX()) {
            e.preventDefault();
            alert("Выберите X!")
        } else {
            document.getElementById("X_field").value = selectedCheckbox.value
            document.getElementById("Y_field").value = document.getElementById("y").value.trim().replace(',', '.').substr(0, 12);
        }
    }
}

function checkY() {
    let y = document.getElementById("y");
    y.value = y.value.trim().substr(0, 12);
    if (y.value.trim() === "") {
        alert("Y не должен быть пустым!");
        return false;
    }
    if (!isFinite(y.value.replace(',', '.'))) {
        alert("Y должен быть числом!");
        return false;
    }
    if (y.value.replace(',', '.') >= 5 || y.value.replace(',', '.') <= -3) {
        alert("Y должен быть в диапазоне (-3; 5)");
        return false;
    }
    return true;
}

function checkX() {
    return selectedCheckbox !== undefined;
}

function changeX(element) {
    if (element.checked) {
        if (selectedCheckbox !== undefined) {
            selectedCheckbox.checked = false;
        }
        selectedCheckbox = element;
    } else {
        selectedCheckbox = undefined;
    }
}


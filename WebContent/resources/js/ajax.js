let content = document.getElementById("ajax-content")

function fetchContent(el) {
    let view = el.getAttribute("a-view")
//    let folder = el.getAttribute("a-folder")
    fetch(`${view}`)
        .then(response => {
            let html = response.text()
            return html
        })
        .then(html => {
            content.innerHTML = html
        })
}
// window.addEventListener('load', function () {
//     const postForm = document.getElementById('post-form');
//     console.log(postForm);

    // function createPost(e){
    //     e.preventDefault();
    //     const form = e.target;
    //     console.log(form);
    //     const data = new FormData(form);
    //     // data.append('user', 1);
    //     console.log(data);
    //     fetch('http://localhost:8989/publication', {
    //         method: 'POST',
    //         body: data
    //     }).then(res => res.json());
    // }
    // postForm.addEventListener('submit', createPost);

'use strict';
window.addEventListener('load', function () {

    const saveButton = document.getElementById("save-post");
    saveButton.addEventListener("click", function() {
        const postForm = document.getElementById("post-form");
        let data = new FormData(postForm);
        data.append("user", "1");

        fetch("http://localhost:9393/publication/", {
            method: 'POST',
            body: data
        }).then(r => r.json()).then(data => {
            window.location.href = "http://localhost:9393/";
        });
    });
});

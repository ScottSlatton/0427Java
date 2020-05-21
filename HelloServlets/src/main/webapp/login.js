let submit = document.getElementById("submit_login");
let space = document.getElementById("space");

submit.addEventListener("click", login)
// submit.addEventListener("keyup", login)

function login(e) {
	// try this to use form
	e.preventDefault();
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    
    console.log(username);
    console.log(password);    

    fetch('http://localhost:9999/HelloServlets/login', {
        method: 'POST',
        body: JSON.stringify({
            username: username,
            password: password
        }),
        headers: {
            "Content-Type": "application/json; charset=UTF-8",
            'Accept': 'application/json'
        }
        })
//         getting response.text instead of response.json,
        // response is from java file, i want to access the
        // url in it to redirect through javascript

        // THIS working approach does a redirect
        // .then(response => response.text())
        // .then(response => {
        //     console.log(response)
        //     window.location.assign(response);
        // })

        // THIS works at dealing with an object
        .then(response => response.json())
        .then(responseObj => {
            console.log(responseObj)
            for (let i in responseObj) {
                console.log(responseObj[i]);
                // let 
                // space.appendChild(info);

                let item = document.createElement("LI");
                let text = document.createTextNode(responseObj[i]);
                item.appendChild(text);
                space.appendChild(item);
            }
        })



//        .then(response => console.log(response.json()));
        // .then(json => console.log(json))
        // .then(json => repeatFeedback(json))

        // function repeatFeedback(json) {
        //     console.log(json) 
//         }
}

// window.location(url)
// window.redirect?

function post(url, body = '{}') {
    return fetch('http://localhost:8029' + url, {
        method: 'POST',
        credentials: 'same-origin',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    });
}

function get(url) {
    return fetch('http://localhost:8029' + url, {
        method: 'GET',
        credentials: 'same-origin'
    });
}

export async function postRegister(credentials) {
    const response = await post('/auth/register', credentials);
    const json = await response.json();
    return json.message;
}

import vue from  "./main"

export async function postLogin(username, password) {
    const response = await post('/auth/login?username=' + encodeURIComponent(username) + "&password=" + encodeURIComponent(password));
    const json = await response.json();
    if (response.status === 200) {
        vue.update(json.username);
        return '200';
    }
    else if (response.status === 401) {
        return 'Incorrect username/password';
    }
}

export async function postSetDot(x, y, r) {

}

export async function postStartGame() {

}

export async function postFinishGame() {

}

export async function getLeaderboard() {

}
function post(url, body = '{}') {
    return fetch(url, {
        method: 'POST',
        credentials: 'same-origin',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    });
}

function get(url) {
    return fetch(url, {
        method: 'GET',
        credentials: 'same-origin'
    });
}

export async function postRegister(credentials) {
    const response = await post('/auth/register', credentials);
    const json = await response.json();
    return json.message;
}

import vue from "./main"

export async function postLogin(username, password) {
    const response = await post('/auth/login?username=' + encodeURIComponent(username) + "&password=" + encodeURIComponent(password));
    if (response.status === 200) {
        const json = await response.json();
        vue.update(json.username);
        return '200';
    } else if (response.status === 401) {
        return 'Incorrect username/password';
    }
}

export async function postSetDot(x, y, r) {
    const response = await post("/dotCheck", {x: x, y: y, r: r});
    const json = await response.json();
    return {figura: json.isHit, time: json.time}
}

export async function getLabDots() {
    const response = await get("/dotCheck/fetchResults");
    return response.json();
}

export async function postEraseDots() {
    return await post("/dotCheck/clear");
}

export async function postStartPractice(){
    const response = await post("/pracCheck");
    return response.json();
}

export async function postFinishPractice(graph) {
    return post("/pracCheck/getResult", graph);
}

export async function postStartCompetitive() {

}

export async function postFinishCompetitive() {

}

export async function getLeaderboard() {

}
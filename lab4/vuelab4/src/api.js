function post(url, body) {
    return fetch(url, {
        method: 'POST',
        credentials: 'same-origin',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    });
}

export async function postRegister(credentials) {
    const response = await post('/auth/signin', credentials);
    const json = await response.json();
    return json.message;
}
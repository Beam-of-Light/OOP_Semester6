var global_token = "";

export function getAirports(){
    console.log("from GET : " + global_token);
    const requestOptions = {
        method: 'Get',
        headers: {
            'Authorization': 'bearer ' + global_token
        },
        //credentials: 'include',
    };
    return fetch(`http://localhost:8081/airports`, requestOptions).then(response => response.json())
        .then((responseData) => {
            return responseData;
        })
}

export function deleteAirport(id){
    const requestOptions = {
        method: 'Delete',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'bearer ' + global_token
        },
        //credentials: 'include',
    };
    return fetch(`http://localhost:8081/airports/${id}`, requestOptions).then(response => response.json())
        .then((responseData) => {
            return responseData;
        })
}

export function deleteFlight(id){
    const requestOptions = {
        method: 'Delete',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'bearer ' + global_token
        },
        //credentials: 'include',
    };
    return fetch(`http://localhost:8081/flights/${id}`, requestOptions).then(response => response.json())
        .then((responseData) => {
            return responseData;
        })
}

export function deleteEmployee(id){
    const requestOptions = {
        method: 'Delete',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'bearer ' + global_token},
        //credentials: 'include',
    };
    return fetch(`http://localhost:8081/employees/${id}`, requestOptions).then(response => response.json())
        .then((responseData) => {
            return responseData;
        })
}

export function deleteEmployeeFromFlight(employeeId, flightId){
    console.log(employeeId + " " + flightId + "!");
    const requestOptions = {
        method: 'Delete',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'bearer ' + global_token
        },
        body: JSON.stringify({ employeeId: employeeId, flightId: flightId}),
        //credentials: 'include',
    };
    fetch('http://localhost:8081/flight_employees', requestOptions).then(response => response.json()).then(data => console.log(data));
}

export function getFlights(){
    const requestOptions = {
        method: 'Get',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'bearer ' + global_token
        },
        //credentials: 'include',
    };
    return fetch(`http://localhost:8081/flights`, requestOptions).then(response => response.json())
        .then((responseData) => {
            return responseData;
        })
}

export function getEmployees(){
    const requestOptions = {
        method: 'Get',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'bearer ' + global_token
        },
        //credentials: 'include',
    };
    return fetch(`http://localhost:8081/employees`, requestOptions).then(response => response.json())
        .then((responseData) => {
            return responseData;
        })
}

export function getFlightEmployees(flightId){
    const requestOptions = {
        method: 'Get',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'bearer ' + global_token
        },
        //credentials: 'include',
    };
    return fetch(`http://localhost:8081/employees?flightId=${flightId}`, requestOptions).then(response => response.json())
        .then((responseData) => {
            return responseData;
        })
}


export function postAirport(name, city, country){
    console.log(name + " " + city + " " + country + "!");
    console.log({ name: name, city: city, country: country });
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'bearer ' + global_token
        },
        body: JSON.stringify({ name: name, city: city, country: country }),
        //credentials: 'include',
    };
    fetch('http://localhost:8081/airports', requestOptions).then(response => response.json()).then(data => console.log(data));


}


export function putAirport(id, name, city, country){
    console.log(name + " " + city + " " + country + "!");
    console.log({ name: name, city: city, country: country });
    const requestOptions = {
        method: 'Put',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'bearer ' + global_token
        },
        body: JSON.stringify({ id:id, name: name, city: city, country: country }),
        //credentials: 'include',
    };
    fetch('http://localhost:8081/airports', requestOptions).then(response => response.json()).then(data => console.log(data));


}

export function putEmployee(id, name, position){
    const requestOptions = {
        method: 'Put',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'bearer ' + global_token
        },
        body: JSON.stringify({ id: id, fullName: name, position: position}),
        //credentials: 'include',
    };
    fetch('http://localhost:8081/employees', requestOptions).then(response => response.json()).then(data => console.log(data));
}


export function postEmployee(name, position){
    console.log(name + " " + position + "!");
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'bearer ' + global_token
        },
        body: JSON.stringify({ fullName: name, position: position}),
        //credentials: 'include',
    };
    fetch('http://localhost:8081/employees', requestOptions).then(response => response.json()).then(data => console.log(data));
}


export function postEmployeeForFlight(employeeId, flightId){
    console.log(employeeId + " " + flightId + "!");
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'bearer ' + global_token
        },
        body: JSON.stringify({ employeeId: employeeId, flightId: flightId}),
        //credentials: 'include',
    };
    fetch('http://localhost:8081/flight_employees', requestOptions).then(response => response.json()).then(data => console.log(data));
}

export function postFlight(datetime, from, to){
    console.log(datetime + " " + from + " " + to + "!");
    console.log({ datetime: datetime.getTime(), from: from, to: to });
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'bearer ' + global_token
        },
        body: JSON.stringify({ datetime: datetime.getTime(), from: from, to: to }),
        //credentials: 'include',
    };
    fetch('http://localhost:8081/flights', requestOptions).then(response => response.json()).then(data => console.log(data));
}

export function putFlight(id, datetime, from, to){
    console.log(datetime + " " + from + " " + to + "!");
    console.log({ datetime: datetime.getTime(), from: from, to: to });
    const requestOptions = {
        method: 'Put',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'bearer ' + global_token
        },
        body: JSON.stringify({ id: id, datetime: datetime.getTime(), from: from, to: to }),
        //credentials: 'include',
    };
    fetch('http://localhost:8081/flights', requestOptions).then(response => response.json()).then(data => console.log(data));
}

export function airlineLogin(login, password){

    /*
        curl -X POST '' --header 'Content-Type: application/x-www-form-urlencoded'  --data-urlencode 'grant_type=password'  --data-urlencode 'client_id=spring-boot-app'  --data-urlencode 'client_secret=4442618d-d029-4c06-b77f-12919d37b263'  --data-urlencode 'username=admin'  --data-urlencode 'password=1'
    */

    var details = {
        'grant_type': 'password',
        'client_id': 'spring-boot-app',
        'client_secret': '4442618d-d029-4c06-b77f-12919d37b263',
        'username': login,
        'password': password
    };

    var formBody = [];
    for (var property in details) {
        var encodedKey = encodeURIComponent(property);
        var encodedValue = encodeURIComponent(details[property]);
        formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");

    return fetch('http://localhost:8180/auth/realms/Airport/protocol/openid-connect/token', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: formBody
    }).then((resp) => resp.json().then(data => {
        console.log(data);
        global_token = data["access_token"];
        console.log("Global token is " + global_token);
        return data
    }));



}

export function getToken() {
    return global_token;
}

export function airlineLogout(){

    var details = {
        'grant_type': 'password',
        'client_id': 'spring-boot-app',
        'client_secret': '4442618d-d029-4c06-b77f-12919d37b263',
    };

    var formBody = [];
    for (var property in details) {
        var encodedKey = encodeURIComponent(property);
        var encodedValue = encodeURIComponent(details[property]);
        formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");

    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'Authorization': 'bearer ' + global_token,
        },
        body: formBody
        //credentials: 'include',
    };
    fetch('\'http://localhost:8180/auth/realms/Airport/protocol/openid-connect/token\'', requestOptions).then(response => response.json()).then((data) => {
        console.log(data);
    });
}

import React from "react";
import {
    BrowserRouter as Router,
    Switch,
    Route,
} from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import Airports from "./pages/admin/Airports";
import Flights from "./pages/admin/Flights";
import Employees from "./pages/admin/Employees";
import Main from "./pages/dispatcher/Main";
import FlightDetails from "./pages/dispatcher/FlightDetails";

export default function App() {
    return (
        <Router>
            <div>
                <Switch>
                    <Route path="/login">
                        <LoginPage />
                    </Route>
                    <Route path="/admin">
                        <Flights />
                    </Route>
                    <Route path="/airports">
                        <Airports />
                    </Route>
                    <Route path="/employees">
                        <Employees />
                    </Route>
                    <Route path="/dispatcher">
                        <Main />
                    </Route>
                    <Route
                        path='/flight'
                        render={(props) => {
                            console.log(
                                "from route flights is " + props.flight
                            )
                            return (
                            <FlightDetails flight={props.flight} />
                        )}}
                    />
                    <Route path="/">
                        <Home />
                    </Route>
                </Switch>
            </div>
        </Router>
    );
}

function Home() {
    return <h2>Home</h2>;
}


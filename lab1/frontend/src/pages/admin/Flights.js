import React from "react";
import {Box, Container} from "@material-ui/core";
import {getAirports, getFlights} from "../../services/AirplaneApiService";
import Header from "../../components/admin/Header";
import FlightsList from "../../components/admin/FlightsList";




class Flights extends React.Component {


    state = {
        flights: [],
        airports: []
    }

    gettingFlight = async () => {
        let flights = await getFlights()
        let airports = await getAirports()
        this.setState({
            flights: flights,
            airports: airports
        });

    }

    constructor(props) {
        super(props);
        this.gettingFlight();
    }

    render() {
        console.log(this.state.flights);
        return (
            <Box>
                <Header />
                <Container fixed>
                    <FlightsList flights={this.state.flights} airports={this.state.airports} />
                </Container>
            </Box>
        );
    }
}


export default Flights;

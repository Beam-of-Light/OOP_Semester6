import React from "react";
import {Box, Container, Grid, Paper} from "@material-ui/core";
import {getAirports, getEmployees, getFlightEmployees} from "../../services/AirplaneApiService";
import Header from "../../components/admin/Header";
import EmployeesList from "../../components/admin/EmployeesList";
import {useLocation} from "react-router";
import { withRouter } from 'react-router-dom'
import FlightEmployeesTable from "../../components/dispatcher/FlightEmployeesTable";
import DHeader from "../../components/dispatcher/DHeader";



class FlightDetails extends React.Component {


    state = {
        employees: [],
        allEmployees: [],
    }

    gettingEmployees = async (flight) => {
        let employees = await getFlightEmployees(flight)
        let allEmployees = await getEmployees()
        console.log(flight);
        console.log(employees);
        this.setState({
            employees: employees,
            allEmployees: allEmployees
        });

    }

    constructor(props) {
        super(props);
        console.log(this.props.location.flight.id + "Ha-ha");
        this.gettingEmployees(this.props.location.flight.id).then(r => console.log("Done"));
    }

    render() {
        console.log(this.state.employees);
        console.log(this.props.flight);
        return (
            <Box>
                <DHeader />
                <Container fixed>
                    <FlightEmployeesTable employees={this.state.employees} flight={this.props.location.flight} allEmployees={this.state.allEmployees}/>
                </Container>
            </Box>
        );
    }
}


export default withRouter(FlightDetails);

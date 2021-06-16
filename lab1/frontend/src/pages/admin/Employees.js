import React from "react";
import {Box, Container, Grid, Paper} from "@material-ui/core";
import {getAirports, getEmployees} from "../../services/AirplaneApiService";
import Header from "../../components/admin/Header";
import EmployeesList from "../../components/admin/EmployeesList";




class Employees extends React.Component {


    state = {
        employees: []
    }

    gettingEmployees = async () => {
        let employees = await getEmployees()
        this.setState({
            employees: employees
        });

    }

    constructor(props) {
        super(props);
        this.gettingEmployees();
    }

    render() {
        console.log(this.state.employees);
        return (
            <Box>
                <Header />
                <Container fixed>
                    <EmployeesList employees={this.state.employees} />
                </Container>
            </Box>
        );
    }
}


export default Employees;

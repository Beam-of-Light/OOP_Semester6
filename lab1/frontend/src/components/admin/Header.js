import React, { Component } from "react";
import {makeStyles, MuiThemeProvider} from '@material-ui/core/styles';

import {AppBar, Box, Button, Container, createMuiTheme, IconButton, Toolbar, Typography} from "@material-ui/core";
import {grey} from "@material-ui/core/colors";
import {useHistory} from "react-router-dom";
import {airlineLogout} from "../../services/AirplaneApiService";

const whiteTheme = createMuiTheme({ palette: { primary: grey } })

const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1
    },
    title: {
        flexGrow: 1
    },
    button: {
        flexGrow: 1,
        marginLeft: theme.spacing(2),
        marginRight: theme.spacing(2)
    },
    menuButton: {
        marginRight:  theme.spacing(1)
    },
    toolbar: theme.mixins.toolbar,

}))

const Header = () => {

    const classes = useStyles();
    const history = useHistory();

    const openFlights = () => {
        history.push("/admin")
    }

    const openAirports = () => {
        history.push("/airports")
    }

    const openEmployees = () => {
        history.push("/employees")
    }


    return (
        <AppBar  position="sticky">
            <Container fixed>
                <Toolbar>

                    <Typography variant="h6" className={classes.title}> Airline app</Typography>
                        <Button color={"inherit"} variant={"text"} className={classes.button} onClick={openFlights}>Flights</Button>
                        <Button color={"inherit"} variant={"text"} className={classes.button} onClick={openAirports}>Airports</Button>
                        <Button color={"inherit"} variant={"text"} className={classes.button} onClick={openEmployees}>Employers</Button>
                    <Button color="secondary" variant="contained" className={classes.menuButton} onClick={() => {airlineLogout(); history.push("/login")}}>Log Out</Button>
                </Toolbar>
            </Container>

        </AppBar>);
};

export default Header;
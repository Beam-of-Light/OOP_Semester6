import React, { Component } from "react";
import {Box, Button, Container, Grid, Typography} from "@material-ui/core";

const AirportsPageInfo = () => {
    return (
    <Grid direction="row" justify="center" alignItems="center">
        <Typography variant={"h4"} > Available airports: </Typography>
        <Button variant={"contained"} color={"primary"}>Add</Button>
    </Grid>)
}

export default AirportsPageInfo;

import React from 'react'
import {
    Box,
    Button,
    ButtonGroup,
    Card,
    CardContent,
    Container,
    Grid,
    Typography
} from "@material-ui/core";

import {makeStyles} from "@material-ui/core/styles";
import AddFlightFormDialog from "./AddFlightFormDialog";
import {deleteEmployee, deleteFlight, getAirports} from "../../services/AirplaneApiService";
import EditFlightFormDialog from "./EditFlightDialog";

const useStyles = makeStyles((theme) => ({
    cardButtonGroup: {
        marginRight:  theme.spacing(1),
        marginBottom:  theme.spacing(2),
        marginLeft:  theme.spacing(1.7)
    },

    infoItem: {
        marginBottom:  theme.spacing(3),
        marginTop:  theme.spacing(3),
        marginLeft:  theme.spacing(2),
        marginRight:  theme.spacing(2),
    },

    airportCard: {
        backgroundColor: "#E5F3FF",
        marginBottom: theme.spacing(6),
    }


}))

const zeroPad = (num, places) => String(num).padStart(places, '0')

const FlightsList = ({ flights, airports }) => {
    const classes = useStyles();
    console.log(flights);
    console.log("!");
    return (
        <Container fixed>
            <Grid direction="row" justify="space-between" alignItems="center" container>
                <Grid item className={classes.infoItem}><Typography variant={"h4"} > Flights: </Typography></Grid>
                <Grid item className={classes.infoItem}><AddFlightFormDialog airports={airports}/></Grid>

            </Grid>
            {flights.map((flight) => (
                <Card className={classes.airportCard}>
                    <CardContent>
                        <Grid direction={"row"} container justify={"space-between"}>
                            <Grid item alignItems>
                                <Typography variant="h4" color={"primary"}>{"Airport " + flight.from.name}</Typography>
                                <Typography variant="subtitle1" color={"primary"}>{flight.from.city + ", " + flight.from.country}</Typography>
                            </Grid>
                            
                            <Grid item >
                                <Typography variant="h4" color={"primary"} align={"right"}>{"Airport " + flight.to.name}</Typography>
                                <Typography variant="subtitle1" color={"primary"} align={"right"}>{flight.to.city + ", " + flight.to.country}</Typography>
                            </Grid>
                        </Grid>

                    </CardContent>
                    <Box justifyContent="flex-end" width={"100%"}>
                        <ButtonGroup color="primary" className={classes.cardButtonGroup} variant={"contained"}>
                            <EditFlightFormDialog airports={airports} flight={flight}/>
                            <Button
                                onClick={() => {
                                    deleteFlight(flight.id).then(r => console.log("Employee deleted"));
                                }}
                            >Delete</Button>
                        </ButtonGroup>
                    </Box>
                </Card>
            ))}



        </Container>
    );
};

export default FlightsList

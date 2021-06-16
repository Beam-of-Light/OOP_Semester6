import React from 'react'
import {
    Box,
    Button,
    ButtonGroup,
    Card,
    CardContent,
    CardHeader,
    Container,
    Grid,
    hexToRgb, IconButton, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Toolbar,
    Typography
} from "@material-ui/core";
import {makeStyles} from "@material-ui/core/styles";
import {Add, Remove} from "@material-ui/icons";
import AddFlightFormDialog from "../admin/AddFlightFormDialog";
import AddEmployeeToFlightFormDialog from "./AddEmployeeToFlightFormDialog";
import {deleteEmployeeFromFlight} from "../../services/AirplaneApiService";

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

    addBtn: {
        marginRight:  theme.spacing(2),
    },
    airportCard: {
        backgroundColor: "#ECE1FE",
        marginBottom: theme.spacing(6),
    },
    table: {
        /*marginBottom:  theme.spacing(3),
        marginTop:  theme.spacing(3),
        marginLeft:  theme.spacing(2),
        marginRight:  theme.spacing(2),*/
    },

}))

const zeroPad = (num, places) => String(num).padStart(places, '0')

const FlightEmployeesTable = ({ employees, flight, allEmployees }) => {
    const classes = useStyles();
    return (
        <Container fixed>
            <Grid direction="row" justify="space-between" alignItems="center" container>
                <Grid item className={classes.infoItem}><Typography variant={"h4"} > Flight info: </Typography></Grid>

            </Grid>
            <Card className={classes.airportCard}
            >
                <CardContent>
                    <Grid direction={"row"} container justify={"space-between"}>
                        <Grid item alignItems>
                            <Typography variant="h4" color={"primary"}>{"Airport " + flight.from.name}</Typography>
                            <Typography variant="subtitle1" color={"primary"}>{flight.from.city + ", " + flight.from.country}</Typography>
                        </Grid>
                        {/*<Grid item>
                            <Typography variant="h4" color={"primary"} align={"center"}>
                                {zeroPad(flight.dateTime.time.hour, 2)
                                + ":" + zeroPad(flight.dateTime.time.minute, 2)}</Typography>

                            <Typography variant="h6" color={"primary"} align={"center"}>{
                                flight.dateTime.date.day.toString()
                                + '/' +
                                flight.dateTime.date.month.toString()
                                + '/' +
                                flight.dateTime.date.year.toString()
                            }</Typography>
                        </Grid>*/}
                        <Grid item >
                            <Typography variant="h4" color={"primary"} align={"right"}>{"Airport " + flight.to.name}</Typography>
                            <Typography variant="subtitle1" color={"primary"} align={"right"}>{flight.to.city + ", " + flight.to.country}</Typography>
                        </Grid>
                    </Grid>

                </CardContent>
            </Card>

            <TableContainer component={Paper} className={classes.table}>
                <Toolbar>
                <Typography className={classes.title} variant="h6" id="tableTitle" component="div">
                    Employees
                </Typography>
                    <AddEmployeeToFlightFormDialog employees={allEmployees} flight={flight}/>
                </Toolbar>
                <Table className={classes.table} size="medium" aria-label="a dense table" title={"Employees"} about={"Employees"}>
                    <TableHead aria-label={"Employees"}>
                        <TableRow>
                            <TableCell padding="checkbox">

                            </TableCell>
                            <TableCell>Id</TableCell>
                            <TableCell>Full name</TableCell>
                            <TableCell align="right">Position</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {employees.map((row) => (
                            <TableRow key={row.id}>
                                <TableCell component="th" scope="row">
                                    <IconButton onClick={ () => {
                                        deleteEmployeeFromFlight(row.id, flight.id)
                                    }}>
                                        <Remove />
                                    </IconButton>
                                </TableCell>
                                <TableCell component="th" scope="row">
                                    {row.id}
                                </TableCell>
                                <TableCell component="th" scope="row">
                                    {row.fullName}
                                </TableCell>
                                <TableCell align="right">{row.position}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>



        </Container>
    );
};

export default FlightEmployeesTable;
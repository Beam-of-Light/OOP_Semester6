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
    hexToRgb,
    Typography
} from "@material-ui/core";
import {makeStyles} from "@material-ui/core/styles";
import AddAirportFormDialog from "./AddAirportFormDialog";
import AddEmployeeFormDialog from "./AddEmployeeFormDialog";
import {deleteAirport, deleteEmployee} from "../../services/AirplaneApiService";
import EditEmployeeForm from "./EditEmployeeForm";

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

const EmployeesList = ({ employees }) => {
    const classes = useStyles();
    return (
        <Container fixed>
            <Grid direction="row" justify="space-between" alignItems="center" container>
                <Grid item className={classes.infoItem}><Typography variant={"h4"} > Employees: </Typography></Grid>
                <Grid item className={classes.infoItem}><AddEmployeeFormDialog/></Grid>

            </Grid>
            {employees.map((employee) => (
                <Card className={classes.airportCard}>
                    <CardContent>
                        <Typography variant="h4" color={"primary"}>{employee.fullName}</Typography>
                        <Typography variant="subtitle1" color={"primary"}>{employee.position}</Typography>
                    </CardContent>
                    <Box justifyContent="flex-end" width={"100%"}>
                        <ButtonGroup color="primary" className={classes.cardButtonGroup} variant={"contained"}>
                            <EditEmployeeForm employee={employee}/>
                            <Button
                                onClick={() => {
                                    deleteEmployee(employee.id).then(r => console.log("Employee deleted"));
                                }}
                            >Delete</Button>
                        </ButtonGroup>
                    </Box>
                </Card>
            ))}



        </Container>
    );
};

export default EmployeesList;
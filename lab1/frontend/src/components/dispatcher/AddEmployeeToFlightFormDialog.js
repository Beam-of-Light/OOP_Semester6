import React from 'react';
import Button from '@material-ui/core/Button';
import 'date-fns';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import {getAirports, postAirport, postEmployeeForFlight, postFlight} from "../../services/AirplaneApiService";
import {Grid, IconButton, Input, MenuItem, Select} from "@material-ui/core";
import {Add} from "@material-ui/icons";
export default function AddEmployeeToFlightFormDialog({ employees, flight }) {
    const [open, setOpen] = React.useState(false);

    const [employee, setEmployee] = React.useState([]);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleFromChange = (event) => {
        setEmployee(event.target.value);
    };

    const submitForm = () => {
        postEmployeeForFlight(employee, flight.id);
        setOpen(false);
    }

    return (
        <div>
            <IconButton onClick={handleClickOpen}>
                <Add />
            </IconButton>

            <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
                <DialogTitle id="form-dialog-title">Create a new flight</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        Please select employee
                    </DialogContentText>

                    <Select
                        labelId="demo-mutiple-name-label"
                        id="demo-mutiple-name"
                        value={employee}
                        onChange={handleFromChange}
                        input={<Input />}
                        label={"Employee"}
                        //MenuProps={MenuProps}
                    >
                        {employees.map((employee) => (
                            <MenuItem key={employee.fullName} value={employee.id} >
                                {employee.position + " " +  employee.fullName}
                            </MenuItem>
                        ))}
                    </Select>


                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose} color="primary">
                        Cancel
                    </Button>
                    <Button onClick={submitForm} color="primary">
                        Add
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}
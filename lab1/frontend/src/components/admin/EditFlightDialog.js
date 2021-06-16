import React from 'react';
import Button from '@material-ui/core/Button';
import 'date-fns';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import {getAirports, postAirport, postFlight, putFlight} from "../../services/AirplaneApiService";
import DateFnsUtils from '@date-io/date-fns';
import { KeyboardDatePicker, MuiPickersUtilsProvider, KeyboardTimePicker } from "@material-ui/pickers";
import {Grid, Input, MenuItem, Select} from "@material-ui/core";
export default function EditFlightFormDialog({ airports, flight }) {
    const [open, setOpen] = React.useState(false);

    //let airports = getAirports();

    const [selectedDate, setSelectedDate] = React.useState(new Date());
    const [from, setFrom] = React.useState(flight.from);
    const [to, setTo] = React.useState(flight.to);

    const handleDateChange = (date) => {
        setSelectedDate(date);
        console.log(date);
    };

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleFromChange = (event) => {
        setFrom(event.target.value);
    };

    const handleToChange = (event) => {
        setTo(event.target.value);
    };

    const submitForm = () => {
        putFlight(flight.id, selectedDate, from, to);
        setOpen(false);
    }


    return (
        <div>
            <Button variant={"contained"} color={"primary"} onClick={handleClickOpen}>Edit</Button>

            <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
                <DialogTitle id="form-dialog-title">Edit flight</DialogTitle>
                <DialogContent>
                    <MuiPickersUtilsProvider utils={DateFnsUtils}>
                        <KeyboardDatePicker
                            disableToolbar
                            fullWidth
                            variant="inline"
                            format="MM/dd/yyyy"
                            margin="normal"
                            id="date-picker-inline"
                            label="Flight date"
                            value={selectedDate}
                            onChange={handleDateChange}
                            KeyboardButtonProps = {{
                                'aria-label': 'change date',
                            }}
                        />

                        <KeyboardTimePicker
                            fullWidth
                            margin="normal"
                            id="time-picker"
                            label="Time picker"
                            value={selectedDate}
                            onChange={handleDateChange}
                            KeyboardButtonProps = {{
                                'aria-label': 'change time',
                            }}
                        />
                    </MuiPickersUtilsProvider>

                    <Select
                        labelId="demo-mutiple-name-label"
                        id="demo-mutiple-name"
                        value={from}
                        onChange={handleFromChange}
                        input={<Input />}
                        label={"FROM"}
                        //MenuProps={MenuProps}
                    >
                        {airports.map((airport) => (
                            <MenuItem key={airport.name} value={airport.id} >
                                {airport.name}
                            </MenuItem>
                        ))}
                    </Select>

                    <Select
                        labelId="demo-mutiple-name-label"
                        id="demo-name"
                        value={to}
                        onChange={handleToChange}
                        input={<Input />}
                        label={"To"}
                        //MenuProps={MenuProps}
                    >
                        {airports.map((airport) => (
                            <MenuItem key={airport.name} value={airport.id} >
                                {airport.name}
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
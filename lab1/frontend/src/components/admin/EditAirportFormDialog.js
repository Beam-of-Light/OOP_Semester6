import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import {postAirport, putAirport} from "../../services/AirplaneApiService";

export default function EditAirportFormDialog( {airport} ) {
    const [open, setOpen] = React.useState(false);

    let name = airport.name;
    let city = airport.city;
    let country = airport.country;

    const handleName = (event) => {
        name = event.target.value;
    }

    const handleCity = (event) => {
        city = event.target.value;
    }

    const handleCountry = (event) => {
        country = event.target.value;
    }

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const submitForm = () => {
        putAirport(airport.id, name, city, country);
        setOpen(false);
    }

    return (
        <div>
            <Button variant={"contained"} color={"primary"} onClick={handleClickOpen}>Edit</Button>
            <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
                <DialogTitle id="form-dialog-title">Edit airport</DialogTitle>
                <DialogContent>
                    <TextField
                        autoFocus
                        defaultValue={name}
                        margin="dense"
                        id="name"
                        label="Airport name"
                        onChange={handleName}
                        fullWidth
                    />

                    <TextField
                        margin="dense"
                        defaultValue={city}
                        id="city"
                        label="City"
                        fullWidth
                        onChange={handleCity}
                    />

                    <TextField
                        margin="dense"
                        defaultValue={country}
                        id="county"
                        label="Country"
                        fullWidth
                        onChange={handleCountry}
                    />
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose} color="primary">
                        Cancel
                    </Button>
                    <Button onClick={submitForm} color="primary">
                        Edit
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}
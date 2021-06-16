import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import {postAirport} from "../../services/AirplaneApiService";

export default function AddAirportFormDialog() {
    const [open, setOpen] = React.useState(false);

    let name = '';
    let city = '';
    let country = '';

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
        postAirport(name, city, country);
        setOpen(false);
    }

    return (
        <div>
            <Button variant={"contained"} color={"secondary"} onClick={handleClickOpen}>Add</Button>
            <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
                <DialogTitle id="form-dialog-title">Add airport</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        Please fill all fields to add airport.
                    </DialogContentText>
                    <TextField
                        autoFocus
                        margin="dense"
                        id="name"
                        label="Airport name"
                        onChange={handleName}
                        fullWidth
                    />

                    <TextField
                        autoFocus
                        margin="dense"
                        id="city"
                        label="City"
                        fullWidth
                        onChange={handleCity}
                    />

                    <TextField
                        autoFocus
                        margin="dense"
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
                        Add
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}
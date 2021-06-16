import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import {postAirport, postEmployee} from "../../services/AirplaneApiService";

export default function AddEmployeeFormDialog() {
    const [open, setOpen] = React.useState(false);

    let fullName = '';
    let position = '';

    const handleName = (event) => {
        fullName = event.target.value;
    }

    const handlePosition = (event) => {
        position = event.target.value;
    }

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const submitForm = () => {
        postEmployee(fullName, position);
        setOpen(false);
    }

    return (
        <div>
            <Button variant={"contained"} color={"secondary"} onClick={handleClickOpen}>Add</Button>
            <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
                <DialogTitle id="form-dialog-title">Add airport</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        Please fill all fields to add employee.
                    </DialogContentText>
                    <TextField
                        autoFocus
                        margin="dense"
                        id="name"
                        label="Full name"
                        onChange={handleName}
                        fullWidth
                    />

                    <TextField
                        margin="dense"
                        id="city"
                        label="Position"
                        fullWidth
                        onChange={handlePosition}
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
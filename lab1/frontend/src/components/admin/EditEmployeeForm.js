import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import {putEmployee} from "../../services/AirplaneApiService";

export default function EditEmployeeForm({employee}) {
    const [open, setOpen] = React.useState(false);

    let fullName = employee.fullName;
    let position = employee.position;

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
        putEmployee(employee.id, fullName, position);
        setOpen(false);
    }

    return (
        <div>
            <Button variant={"contained"} color={"primary"} onClick={handleClickOpen}>Edit</Button>
            <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
                <DialogTitle id="form-dialog-title">Edit profile</DialogTitle>
                <DialogContent>
                    <TextField
                        autoFocus
                        defaultValue={fullName}
                        margin="dense"
                        id="name"
                        label="Full name"
                        onChange={handleName}
                        fullWidth
                    />

                    <TextField
                        defaultValue={position}
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
                        Edit
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}
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
import {deleteAirport} from "../../services/AirplaneApiService";
import EditAirportFormDialog from "./EditAirportFormDialog";

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

const AirportList = ({ airports }) => {
    const classes = useStyles();
  return (
    <Container fixed>
        <Grid direction="row" justify="space-between" alignItems="center" container>
            <Grid item className={classes.infoItem}><Typography variant={"h4"} > Available airports: </Typography></Grid>
            <Grid item className={classes.infoItem}><AddAirportFormDialog/></Grid>

        </Grid>
      {airports.map((airport) => (
          <Card className={classes.airportCard}>
              <CardContent>
                  <Typography variant="h4" color={"primary"}>{"Airport " + airport.name}</Typography>
                  <Typography variant="subtitle1" color={"primary"}>{airport.city + ", " + airport.country}</Typography>
              </CardContent>
              <Box justifyContent="flex-end" width={"100%"}>
                  <ButtonGroup color="primary" className={classes.cardButtonGroup} variant={"contained"}>
                      <EditAirportFormDialog airport={airport}/>
                      <Button
                        onClick={() => {
                            deleteAirport(airport.id).then(r => console.log("Airport deleted"));
                        }}
                      >Delete</Button>
                  </ButtonGroup>
              </Box>
          </Card>
      ))}



    </Container>
  );
};

export default AirportList
import React from "react";
import {
    Button,
    Card,
    Grid,
    GridColumn,
    Image,
    FormField,
} from "semantic-ui-react";
import { Formik, Form } from "formik";
import * as Yup from "yup";

export default function CreateCv() {
    return (
        <div>
            <Grid>
                <Grid.Row>
                    <GridColumn width={5}>
                        <h1>Cv Oluştur</h1>
                    </GridColumn>
                    <GridColumn width={8}>
                        <Formik initialValues={{}}></Formik>
                        <Card.Group>
                            <Card fluid>
                                <Card.Content>
                                    <Image
                                        floated="right"
                                        size="mini"
                                        src="https://react.semantic-ui.com/images/avatar/large/jenny.jpg"
                                    />
                                    <Card.Header></Card.Header>
                                    <Card.Meta>New User</Card.Meta>
                                    <Card.Description>
                                        Jenny requested permission to view your
                                        contact details
                                    </Card.Description>
                                </Card.Content>
                            </Card>
                        </Card.Group>
                    </GridColumn>
                </Grid.Row>
            </Grid>
        </div>
    );
}

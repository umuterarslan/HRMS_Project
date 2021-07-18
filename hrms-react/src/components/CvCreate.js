import React, { useState, useEffect } from "react";
import { Button, Container, FormField } from "semantic-ui-react";
import { Formik, Form, Field } from "formik";
import { ToastContainer, toast, Zoom, Bounce } from "react-toastify";
import CurriculaVitaeService from "../services/curriculaVitaeService";

export default function CreateCv() {
    const jobSeekerId = 9;

    const curriculaVitaeService = new CurriculaVitaeService();

    return (
        <div>
            <ToastContainer />
            <Container
                style={{
                    padding: "10px",
                    border: "solid 1px #0652dd",
                    width: "50%",
                    marginTop: "20%",
                    boxShadow: "6px 8px 10px 2px rgba(9, 132, 227, 0.4)",
                }}
            >
                <h4>
                    Kendin hakkında bilgileri yazıp oluşturduktan sonra
                    detayları ekleyebilirsin!
                </h4>
                <Formik
                    initialValues={{
                        coverLetter: "",
                    }}
                    onSubmit={(values) => {
                        console.log(values);
                        const cv = {
                            id: 0,
                            jobSeekerId: jobSeekerId,
                            coverLetter: values.coverLetter,
                        };
                        curriculaVitaeService
                            .addCv(cv)
                            .then((success) => {
                                console.log(success);
                                toast.success(success, {
                                    draggable: true,
                                    position: toast.POSITION.TOP_RIGHT,
                                    transition: Bounce,
                                });
                            })
                            .catch((error) => {
                                toast.error(error, {
                                    draggable: true,
                                    position: toast.POSITION.TOP_RIGHT,
                                    transition: Bounce,
                                });
                            });
                    }}
                >
                    <Form className="ui form">
                        <FormField>
                            <Field
                                as="textarea"
                                name="coverLetter"
                                placeholder="Kendin hakkında ek bilgiler yazabilirsin."
                            ></Field>
                        </FormField>
                        <Button
                            type="sumbit"
                            color="green"
                            style={{
                                marginLeft: "83%",
                            }}
                        >
                            Oluştur
                        </Button>
                    </Form>
                </Formik>
            </Container>
        </div>
    );
}

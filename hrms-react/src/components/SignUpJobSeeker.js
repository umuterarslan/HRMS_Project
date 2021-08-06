import React from "react";
import {
    Button,
    Container,
    FormField,
    Label,
    Checkbox,
} from "semantic-ui-react";
import { Formik, Form, Field } from "formik";
import * as Yup from "yup";
import JobSeekerService from "../services/jobSeekerService";
import { ToastContainer, toast, Zoom, Bounce } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

export default function SignUpJobSeeker() {
    const jobSeekerService = new JobSeekerService();

    return (
        <div
            style={{
                width: "44%",
            }}
        >
            <ToastContainer />
            <Container>
                <Formik
                    initialValues={{
                        id: 0,
                        firstName: "elma",
                        lastName: "elma",
                        identityNumber: "11111111116",
                        email: "elma@gmail.com",
                        birthDate: "1010-10-10",
                        password: "123123",
                        confirmPassword: "123123",
                        termsAccepted: false,
                    }}
                    validationSchema={Yup.object({
                        firstName: Yup.string().required(
                            "Bu alan boş bırakılamaz!"
                        ),
                        lastName: Yup.string().required(
                            "Bu alan boş bırakılamaz!"
                        ),
                        identityNumber: Yup.number()
                            .typeError("Sadece rakamlardan oluşmalıdır!")
                            .required("Bu alan boş bırakılamaz")
                            .min(
                                11,
                                "Vatandaşlık numarası 11 karakter içermelidir!"
                            )
                            .max(
                                11,
                                "Vatandaşlık numarası 11 karakter içermelidir!"
                            ),
                        email: Yup.string()
                            .email("E-Posta formatı doğru değil")
                            .required("Bu alan boş bırakılamaz!"),
                        password: Yup.string()
                            .required("Bu alan boş bırakılamaz!")
                            .min(6, "Parola en az 6 karakterden oluşmalıdır")
                            .max(
                                25,
                                "Parola 25 karakterden fazla olmamalıdır!"
                            ),
                        confirmPassword: Yup.string().required(
                            "Bu alan boş bırakılamaz! Lütfen parolanı doğrula!"
                        ),
                        termsAccepted: Yup.boolean().required(
                            "Kayıt olabilmek için sözleşme kabul edilmelidir!"
                        ),
                    })}
                    onSubmit={(values, actions) => {
                        if (!values.termsAccepted) {
                            toast.error(
                                "Kullanıcı sözleşmesi kabul edilmeli!",
                                {
                                    draggable: true,
                                    position: toast.POSITION.TOP_RIGHT,
                                    transition: Bounce,
                                }
                            );
                        } else if (values.password !== values.confirmPassword) {
                            toast.error("Parola doğrulaması başarısız!", {
                                draggable: true,
                                position: toast.POSITION.TOP_RIGHT,
                                transition: Bounce,
                            });
                        } else {
                            const regulated = {
                                birthDate: values.birthDate,
                                email: values.email,
                                firstName: values.firstName,
                                id: values.id,
                                identityNumber: values.identityNumber,
                                lastName: values.lastName,
                                password: values.password,
                            };
                            jobSeekerService
                                .addJobSeeker(regulated)
                                .then((res) => {
                                    if (res.success === false) {
                                        toast.error(res.message, {
                                            draggable: true,
                                            position: toast.POSITION.TOP_RIGHT,
                                            transition: Bounce,
                                        });
                                        setTimeout(() => {
                                            actions.setSubmitting(false);
                                        }, 1000);
                                    } else {
                                        toast.success(res.message, {
                                            draggable: true,
                                            position: toast.POSITION.TOP_RIGHT,
                                            transition: Zoom,
                                        });
                                        setTimeout(() => {
                                            actions.resetForm();
                                        }, 1000);
                                    }
                                })
                                .catch(() => {
                                    toast.error("Bir hata oluştu!");
                                });
                        }
                    }}
                >
                    {({
                        values,
                        errors,
                        touched,
                        handleSubmit,
                        handleChange,
                        dirty,
                    }) => (
                        <Form onSubmit={handleSubmit} className="ui form">
                            <FormField>
                                <Field
                                    name="firstName"
                                    type="text"
                                    placeholder="Ad"
                                    value={values.firstName}
                                    onChange={handleChange}
                                />
                                {errors.firstName && touched.firstName ? (
                                    <Label basic color="red" pointing>
                                        {errors.firstName}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                <Field
                                    name="lastName"
                                    type="text"
                                    placeholder="Soyad"
                                    value={values.lastName}
                                    onChange={handleChange}
                                />
                                {errors.lastName && touched.lastName ? (
                                    <Label basic color="red" pointing>
                                        {errors.lastName}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                <Field
                                    name="identityNumber"
                                    type="text"
                                    placeholder="Vatandaşlık Numarası"
                                    maxLength={11}
                                    value={values.identityNumber}
                                    onChange={handleChange}
                                />
                                {errors.identityNumber &&
                                touched.identityNumber ? (
                                    <Label basic color="red" pointing>
                                        {errors.identityNumber}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                <Field
                                    name="email"
                                    type="email"
                                    placeholder="E-Posta"
                                    value={values.email}
                                    onChange={handleChange}
                                />
                                {errors.email && touched.email ? (
                                    <Label basic color="red" pointing>
                                        {errors.email}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                <Field
                                    name="birthDate"
                                    type="date"
                                    placeholder="Doğum Tarihi"
                                    value={values.birthDate}
                                    onChange={handleChange}
                                />
                                {errors.birthDate && touched.birthDate ? (
                                    <Label basic color="red" pointing>
                                        {errors.birthDate}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                <Field
                                    name="password"
                                    type="password"
                                    placeholder="Parola"
                                    value={values.password}
                                    onChange={handleChange}
                                />
                                {errors.password && touched.password ? (
                                    <Label basic color="red" pointing>
                                        {errors.password}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                <Field
                                    name="confirmPassword"
                                    type="password"
                                    placeholder="Parola Tekrar"
                                    value={values.confirmPassword}
                                    onChange={handleChange}
                                />
                            </FormField>
                            <FormField>
                                <Checkbox
                                    name="termsAccepted"
                                    label="Kullunıcı sözleşmesini okudum kabul
                                        ediyorum."
                                    onChange={handleChange}
                                    onClick={() =>
                                        (values.termsAccepted =
                                            !values.termsAccepted)
                                    }
                                />
                            </FormField>
                            <Button
                                type="submit"
                                color="green"
                                disabled={!dirty}
                                fluid
                            >
                                Üye Ol
                            </Button>
                        </Form>
                    )}
                </Formik>
            </Container>
        </div>
    );
}

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
import EmployerService from "../services/employerService";
import { ToastContainer, toast, Zoom, Bounce } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

export default function SingUpEmployer() {
    const employerService = new EmployerService();

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
                        companyName: "lale",
                        confirmPassword: "123123",
                        email: "self@lale.com",
                        password: "123123",
                        phoneNumber: "4444444",
                        website: "www.lale.com",
                        termsAccepted: false,
                    }}
                    validationSchema={Yup.object({
                        companyName: Yup.string().required(
                            "Bu alan boş bırakılamaz!"
                        ),
                        website: Yup.string().required(
                            "Bu alan boş bırakılamaz!"
                        ),
                        phoneNumber: Yup.string().required(
                            "Bu alan boş bırakılamaz"
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
                            console.log("Kullanıcı sözleşmesi kabul edilmeli!");
                            toast.error(
                                "Kullanıcı sözleşmesi kabul edilmeli!",
                                {
                                    draggable: true,
                                    position: toast.POSITION.TOP_RIGHT,
                                    transition: Bounce,
                                }
                            );
                        } else if (values.password !== values.confirmPassword) {
                            console.log("Parola doğrulaması başarısız!");
                            toast.error("Parola doğrulaması başarısız!", {
                                draggable: true,
                                position: toast.POSITION.TOP_RIGHT,
                                transition: Bounce,
                            });
                        } else {
                            const regulated = {
                                companyName: values.companyName,
                                email: values.email,
                                website: values.website,
                                id: values.id,
                                phoneNumber: values.phoneNumber,
                                password: values.password,
                            };
                            employerService
                                .addEmployer(regulated)
                                .then((success) => {
                                    console.log(success.message);
                                    if (success.success === false) {
                                        toast.error(success.message, {
                                            draggable: true,
                                            position: toast.POSITION.TOP_RIGHT,
                                            transition: Bounce,
                                        });
                                    } else {
                                        toast.success(success.message, {
                                            draggable: true,
                                            position: toast.POSITION.TOP_RIGHT,
                                            transition: Zoom,
                                        });
                                        setTimeout(() => {
                                            actions.resetForm();
                                        }, 1000);
                                    }
                                })
                                .catch((err) => {
                                    console.log(err);
                                });
                        }
                    }}
                >
                    {({ values, errors, touched, handleChange, dirty }) => (
                        <Form
                            className="ui form"
                            style={{
                                width: "30rem",
                            }}
                        >
                            <FormField>
                                <Field
                                    name="companyName"
                                    type="text"
                                    placeholder="Şirket Adı"
                                    value={values.companyName}
                                    onChange={handleChange}
                                />
                                {errors.companyName && touched.companyName ? (
                                    <Label basic color="red" pointing>
                                        {errors.companyName}
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
                                    name="website"
                                    type="text"
                                    placeholder="Şirket Web Adresi"
                                    value={values.website}
                                    onChange={handleChange}
                                />
                                {errors.website && touched.website ? (
                                    <Label basic color="red" pointing>
                                        {errors.website}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                <Field
                                    name="phoneNumber"
                                    type="text"
                                    placeholder="Telefon Numarası"
                                    value={values.phoneNumber}
                                    onChange={handleChange}
                                />
                                {errors.phoneNumber && touched.phoneNumber ? (
                                    <Label basic color="red" pointing>
                                        {errors.phoneNumber}
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
                                {errors.confirmPassword &&
                                touched.confirmPassword ? (
                                    <Label basic color="red" pointing>
                                        {errors.confirmPassword}
                                    </Label>
                                ) : null}
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

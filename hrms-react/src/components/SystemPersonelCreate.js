import React from "react";
import { Formik, Form, Field } from "formik";
import * as Yup from "yup";
import { FormField, Button, Label } from "semantic-ui-react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import SystemPersonelService from "../services/systemPersonelService";

export default function SystemPersonelCreate() {
    const systemPersonelService = new SystemPersonelService();

    const initialValues = {
        id: 0,
        email: undefined,
        password: undefined,
        username: undefined,
    };

    const formSchema = Yup.object({
        email: Yup.string()
            .email("E-Posta formatına uygun olmalıdır!")
            .required("Bu alan boş bırakılamaz!"),
        password: Yup.string()
            .required("Bu alan boş bırakılamaz!")
            .min(6, "En az 6 karakterden oluşmalıdır!"),
        passwordConfirmation: Yup.string()
            .oneOf([Yup.ref("password"), null], "Parolalar eşit değil!")
            .required("Bu alan boş bırakılamaz!"),
        username: Yup.string().required("Bu alan boş bırakılamaz!"),
    });

    return (
        <div
            style={{
                width: "35%",
                marginLeft: "30%",
                marginTop: "12%",
            }}
        >
            <ToastContainer />
            <h2>Sistem personeli için hesap oluştur.</h2>
            <div
                style={{
                    border: "solid 4px #0652dd",
                    boxShadow: "8px 8px 10px 2px rgba(9, 132, 227, 0.4)",
                    borderRadius: "5px",
                    padding: "10px",
                }}
            >
                <Formik
                    initialValues={initialValues}
                    validationSchema={formSchema}
                    onSubmit={(values, actions) => {
                        systemPersonelService
                            .addSystemPersonel(values)
                            .then((success) => {
                                if (
                                    success.data.message ===
                                    "Kullanılan E-Posta adresi zaten kayıtlı!"
                                ) {
                                    toast.error(success.data.message);
                                    return null;
                                } else if (success.data.success === false) {
                                    toast.error("Bir hata oluştu!");
                                    return null;
                                } else {
                                    toast.success(success.data.message);
                                    setTimeout(() => {
                                        actions.setValues({
                                            id: 0,
                                            username: "",
                                            email: "",
                                            password: "",
                                            passwordConfirmation: "",
                                        });
                                        actions.resetForm();
                                        actions.setSubmitting(false);
                                    }, 1000);
                                    return null;
                                }
                            })
                            .catch(() => {
                                toast.error("Sunucu hatası!");
                            });
                    }}
                >
                    {({ values, errors, touched, dirty, isSubmitting }) => (
                        <Form className="ui form">
                            <FormField>
                                Kullanıcı Adı
                                <Field
                                    as="input"
                                    name="username"
                                    type="text"
                                    value={values.username}
                                ></Field>
                                {errors.username && touched.username ? (
                                    <Label basic color="red" pointing>
                                        {errors.username}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                E-Posta
                                <Field
                                    as="input"
                                    name="email"
                                    type="email"
                                    value={values.email}
                                ></Field>
                                {errors.email && touched.email ? (
                                    <Label basic color="red" pointing>
                                        {errors.email}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                Parola
                                <Field
                                    as="input"
                                    name="password"
                                    type="password"
                                    value={values.password}
                                ></Field>
                                {errors.password && touched.password ? (
                                    <Label basic color="red" pointing>
                                        {errors.password}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                Parola Doğrulama
                                <Field
                                    as="input"
                                    name="passwordConfirmation"
                                    type="password"
                                ></Field>
                                {errors.passwordConfirmation &&
                                touched.passwordConfirmation ? (
                                    <Label basic color="red" pointing>
                                        {errors.passwordConfirmation}
                                    </Label>
                                ) : null}
                            </FormField>
                            <Button
                                type="submit"
                                color="green"
                                disabled={!dirty || isSubmitting}
                                fluid
                            >
                                Hesap Oluştur
                            </Button>
                        </Form>
                    )}
                </Formik>
            </div>
        </div>
    );
}

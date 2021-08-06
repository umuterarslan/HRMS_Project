import React, { useEffect, useState } from "react";
import { Formik, Form, Field } from "formik";
import * as Yup from "yup";
import { FormField, Button, Label } from "semantic-ui-react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import EmployerService from "../services/employerService";
import JobPoistionService from "../services/jobPositionService";
import CityService from "../services/cityService";
import JobAdvertService from "../services/jobAdvertService";

export default function JobAdvertCreate() {
    const employerId = 3;

    const employerSerive = new EmployerService();
    const jobPositionService = new JobPoistionService();
    const cityService = new CityService();
    const jobAdvertService = new JobAdvertService();

    const [employer, setEmployer] = useState({});
    const [cities, setCities] = useState([]);
    const [jobPositions, setJobPositions] = useState([]);

    useEffect(() => {
        employerSerive.getEmployerById(employerId).then((success) => {
            setEmployer(success.data.data);
        });
        cityService.getCities().then((success) => {
            setCities(success.data.data);
        });
        jobPositionService.getJobPositions().then((success) => {
            setJobPositions(success.data.data);
        });
    }, []);

    console.log(employer);

    const remoteOrStandartSelect = [
        { key: 1, label: "Ofisten Çalışma", value: "Ofisten Çalışma" },
        { key: 2, label: "Uzaktan Çalışma", value: "Uzaktan Çalışma" },
    ];

    const partOrFullSelect = [
        { key: 1, label: "Tam Zamanlı", value: "Tam Zamanlı" },
        { key: 2, label: "Yarı Zamanlı", value: "Yarı Zamanlı" },
    ];

    const initialValues = {
        cityId: undefined,
        description: undefined,
        employerId: employerId,
        expireDate: undefined,
        id: 0,
        jobPositionId: undefined,
        partOrFullTime: undefined,
        positionCount: undefined,
        remoteOrStandartTyped: undefined,
        salary: undefined,
    };

    const formSchema = Yup.object({
        cityId: Yup.number().required("Bu alan zorunludur!"),
        description: Yup.string().required("Bu alan zorunludur!"),
        expireDate: Yup.date().required("Bu alan zorunludur!"),
        jobPositionId: Yup.number().required("Bu alan zorunludur!"),
        partOrFullTime: Yup.string().required("Bu alan zorunludur!"),
        positionCount: Yup.number()
            .typeError("Sadece rakamlardan oluşmalıdır!")
            .required("Bu alan zorunludur!")
            .positive()
            .min(1, "Pozitif sayı yazılmalıdır!"),
        remoteOrStandartTyped: Yup.string().required("Bu alan zorunludur!"),
        salary: Yup.number()
            .typeError("Sadece rakamlardan oluşmalıdır!")
            .required("Bu alan zorunludur!")
            .positive()
            .min(1, "Pozitif sayı yazılmalıdır!"),
    });

    return (
        <div
            style={{
                width: "50%",
                marginLeft: "25%",
            }}
        >
            <ToastContainer />
            <h2>{employer.companyName} şirketi için bir iş ilanı oluştur!</h2>
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
                        jobAdvertService
                            .addJobAdvert(values)
                            .then((success) => {
                                toast.success(success);
                                setTimeout(() => {
                                    actions.setValues({
                                        cityId: "",
                                        description: "",
                                        employerId: "",
                                        expireDate: "",
                                        id: 0,
                                        jobPositionId: "",
                                        partOrFullTime: "",
                                        positionCount: "",
                                        remoteOrStandartTyped: "",
                                        salary: "",
                                    });
                                    actions.resetForm();
                                    actions.setSubmitting(false);
                                }, 1000);
                            })
                            .catch((error) => {
                                toast.error("Bir hata oluştu!");
                            });
                    }}
                >
                    {({ values, errors, touched, dirty, isSubmitting }) => (
                        <Form className="ui form">
                            <FormField>
                                <Field
                                    as="select"
                                    name="cityId"
                                    placeholder="Şehir seç"
                                    value={values.cityId}
                                >
                                    <option
                                        className="create-job-advert-selects"
                                        value=""
                                        selected
                                        disabled
                                        hidden
                                    >
                                        Şehir
                                    </option>
                                    {cities.map((city) => {
                                        return (
                                            <option
                                                key={city.id}
                                                value={city.id}
                                            >
                                                {city.cityName}
                                            </option>
                                        );
                                    })}
                                </Field>
                                {errors.cityId && touched.cityId ? (
                                    <Label basic color="red" pointing>
                                        {errors.cityId}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                <Field
                                    as="select"
                                    name="jobPositionId"
                                    placeholder="Çalışma pozisyonu"
                                    value={values.jobPositionId}
                                >
                                    <option
                                        className="create-job-advert-selects"
                                        value=""
                                        selected
                                        disabled
                                        hidden
                                    >
                                        Çalışma pozisyonu
                                    </option>
                                    {jobPositions.map((jobPosition) => {
                                        return (
                                            <option
                                                key={jobPosition.id}
                                                value={jobPosition.id}
                                            >
                                                {jobPosition.jobTitle}
                                            </option>
                                        );
                                    })}
                                </Field>
                                {errors.jobPositionId &&
                                touched.jobPositionId ? (
                                    <Label basic color="red" pointing>
                                        {errors.jobPositionId}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                <Field
                                    as="select"
                                    name="remoteOrStandartTyped"
                                    placeholder="Çalışma şekli"
                                    value={values.remoteOrStandartTyped}
                                >
                                    <option
                                        className="create-job-advert-selects"
                                        value=""
                                        selected
                                        disabled
                                        hidden
                                    >
                                        Uzaktan/Ofisten Çalışma
                                    </option>
                                    {remoteOrStandartSelect.map((rOSS) => {
                                        return (
                                            <option
                                                key={rOSS.key}
                                                value={rOSS.value}
                                            >
                                                {rOSS.label}
                                            </option>
                                        );
                                    })}
                                </Field>
                                {errors.remoteOrStandartTyped &&
                                touched.remoteOrStandartTyped ? (
                                    <Label basic color="red" pointing>
                                        {errors.remoteOrStandartTyped}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                <Field
                                    as="select"
                                    name="partOrFullTime"
                                    placeholder="Çalışma zamanı"
                                    value={values.partOrFullTime}
                                >
                                    <option
                                        className="create-job-advert-selects"
                                        value=""
                                        selected
                                        disabled
                                        hidden
                                    >
                                        Tam/Yarı Zamanlı
                                    </option>
                                    {partOrFullSelect.map((pOFS) => {
                                        return (
                                            <option
                                                key={pOFS.key}
                                                value={pOFS.value}
                                            >
                                                {pOFS.label}
                                            </option>
                                        );
                                    })}
                                </Field>
                                {errors.partOrFullTime &&
                                touched.partOrFullTime ? (
                                    <Label basic color="red" pointing>
                                        {errors.partOrFullTime}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                <Field
                                    as="input"
                                    name="salary"
                                    placeholder="Aylık ücret"
                                    value={values.salary}
                                ></Field>
                                {errors.salary && touched.salary ? (
                                    <Label basic color="red" pointing>
                                        {errors.salary}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                <Field
                                    as="input"
                                    name="positionCount"
                                    placeholder="Alınacak personel sayısı"
                                    value={values.positionCount}
                                ></Field>
                                {errors.positionCount &&
                                touched.positionCount ? (
                                    <Label basic color="red" pointing>
                                        {errors.positionCount}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                <Field
                                    as="input"
                                    name="expireDate"
                                    type="date"
                                    value={values.expireDate}
                                ></Field>
                                {errors.expireDate && touched.expireDate ? (
                                    <Label basic color="red" pointing>
                                        {errors.expireDate}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                <Field
                                    as="textarea"
                                    name="description"
                                    placeholder="İş ilanı için gerekli açıklamalar"
                                    value={values.description}
                                ></Field>
                                {errors.description && touched.description ? (
                                    <Label basic color="red" pointing>
                                        {errors.description}
                                    </Label>
                                ) : null}
                            </FormField>
                            <Button
                                type="submit"
                                color="green"
                                disabled={!dirty || isSubmitting}
                                fluid
                            >
                                İlan Oluştur
                            </Button>
                        </Form>
                    )}
                </Formik>
            </div>
        </div>
    );
}

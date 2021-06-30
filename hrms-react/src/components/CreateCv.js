import React, { useState, useEffect } from "react";
// import _ from "lodash";
import {
    Button,
    Card,
    Grid,
    GridColumn,
    Image,
    Form,
    Input,
    TextArea,
    Table,
    Dropdown,
    Select,
} from "semantic-ui-react";
import { Formik } from "formik";
import * as Yup from "yup";
import JobSeekerSerive from "../services/jobSeekerService";
import SchoolService from "../services/schoolService";
import DepartmentService from "../services/departmentService";
import CurriculaVitaeService from "../services/curriculaVitaeService";

export default function CreateCv() {
    const curriculaVitaeService = new CurriculaVitaeService();
    const [jobSeeker, setJobSeeker] = useState({});
    const [schools, setSchools] = useState([]);
    const [departments, setDepartments] = useState([]);
    useEffect(() => {
        const jobSeekerService = new JobSeekerSerive();
        jobSeekerService
            .getJobSeekerById(2)
            .then((success) => setJobSeeker(success.data.data));
        const schoolService = new SchoolService();
        schoolService
            .getSchools()
            .then((success) => setSchools(success.data.data));
        const departmentService = new DepartmentService();
        departmentService
            .getDepartments()
            .then((success) => setDepartments(success.data.data));
    }, []);

    // useEffect(() => {
    //     const schoolService = new SchoolService();
    //     schoolService
    //         .getSchools()
    //         .then((success) => setSchools(success.data.data));
    // }, []);

    // useEffect(() => {
    //     const departmentService = new DepartmentService();
    //     departmentService
    //         .getDepartments()
    //         .then((success) => setDepartments(success.data.data));
    // }, []);

    return (
        <div>
            <Grid>
                <Grid.Row>
                    <GridColumn width={5}>
                        <h1>Cv Oluştur</h1>
                    </GridColumn>
                    <GridColumn width={8}>
                        <Formik
                            enableReinitialize={true}
                            initialValues={jobSeeker}
                            onSubmit={(values) => {
                                curriculaVitaeService
                                    .addCv(values)
                                    .then((res) => console.log(res.message))
                                    .catch((error) => error.message);
                            }}
                        >
                            {({ values, handleChange }) => (
                                <Card.Group>
                                    <Card
                                        style={{
                                            minWidth: "151.5%",
                                        }}
                                    >
                                        <Card.Content>
                                            <Image
                                                floated="right"
                                                size="small"
                                                src="https://react.semantic-ui.com/images/avatar/large/jenny.jpg"
                                            />
                                            <div style={{ display: "inline" }}>
                                                <Card.Header
                                                    as={Input}
                                                    id="firstName"
                                                    type="text"
                                                    placeholder="Ad"
                                                    value={values.firstName}
                                                    onChange={handleChange}
                                                />
                                                <Card.Header
                                                    as={Input}
                                                    id="lastName"
                                                    type="text"
                                                    placeholder="Soyad"
                                                    value={values.lastName}
                                                    onChange={handleChange}
                                                />
                                            </div>
                                            <div>
                                                <Card.Header
                                                    as={Input}
                                                    id="email"
                                                    type="text"
                                                    placeholder="E-Posta"
                                                    value={values.email}
                                                    onChange={handleChange}
                                                />
                                                <Card.Header
                                                    as={Input}
                                                    id="identityNumber"
                                                    type="text"
                                                    placeholder="Kimlik Numarası"
                                                    value={
                                                        values.identityNumber
                                                    }
                                                    onChange={handleChange}
                                                />
                                            </div>
                                            <div>
                                                <Card.Header
                                                    as={Input}
                                                    id="birthDate"
                                                    type="date"
                                                    placeholder="Doğum Tarihi"
                                                    value={values.birthDate}
                                                    onChange={handleChange}
                                                />
                                                <Card.Header
                                                    style={{
                                                        marginLeft: "2.7%",
                                                    }}
                                                    as={Input}
                                                    id="githubUsername"
                                                    type="text"
                                                    placeholder="Github Kullanıcı Adı"
                                                    value={
                                                        values.githubUsername
                                                    }
                                                    onChange={handleChange}
                                                />
                                                <Card.Header
                                                    style={{
                                                        marginLeft: "2.7%",
                                                    }}
                                                    as={Input}
                                                    id="linkedinUsername"
                                                    type="text"
                                                    placeholder="Linkenin Kullanıcı Adı"
                                                    value={
                                                        values.linkedinUsername
                                                    }
                                                    onChange={handleChange}
                                                />
                                            </div>
                                            <div>
                                                <Table celled>
                                                    <Table.Header>
                                                        <Table.Row>
                                                            <Table.HeaderCell>
                                                                Üniversite
                                                            </Table.HeaderCell>
                                                            <Table.HeaderCell>
                                                                Bölüm
                                                            </Table.HeaderCell>
                                                            <Table.HeaderCell>
                                                                Başlama Tarihi
                                                            </Table.HeaderCell>
                                                            <Table.HeaderCell>
                                                                Bitirme Tarihi
                                                            </Table.HeaderCell>
                                                        </Table.Row>
                                                    </Table.Header>

                                                    <Table.Body>
                                                        <Table.Row>
                                                            <Table.Cell>
                                                                <Select
                                                                    className="cv-select"
                                                                    placeholder="Üniversite seç"
                                                                    clearable
                                                                    search
                                                                    selection
                                                                    options={schools.map(
                                                                        (
                                                                            school,
                                                                            e
                                                                        ) => ({
                                                                            text: school.schoolName,
                                                                            value: e,
                                                                        })
                                                                    )}
                                                                />
                                                            </Table.Cell>
                                                            <Table.Cell>
                                                                <Select
                                                                    className="cv-select"
                                                                    placeholder="Bölüm seç"
                                                                    clearable
                                                                    search
                                                                    selection
                                                                    options={departments.map(
                                                                        (
                                                                            department,
                                                                            e
                                                                        ) => ({
                                                                            text: department.departmentName,
                                                                            value: e,
                                                                        })
                                                                    )}
                                                                />
                                                            </Table.Cell>
                                                            <Table.Cell>
                                                                <Input
                                                                    type="date"
                                                                    id="startDate"
                                                                    value={
                                                                        values.startDate
                                                                    }
                                                                    onChange={
                                                                        handleChange
                                                                    }
                                                                />
                                                            </Table.Cell>
                                                            <Table.Cell>
                                                                <Input
                                                                    type="date"
                                                                    id="endDate"
                                                                    value={
                                                                        values.endDate
                                                                    }
                                                                    onChange={
                                                                        handleChange
                                                                    }
                                                                />
                                                            </Table.Cell>
                                                        </Table.Row>
                                                    </Table.Body>
                                                </Table>
                                            </div>
                                            <Card.Description
                                                style={{
                                                    resize: "none",
                                                }}
                                                cols={126}
                                                rows={10}
                                                maxLength={1000}
                                                placeholder=" 1000 Karakter ile sınırlıdır."
                                                as={TextArea}
                                            />
                                        </Card.Content>
                                    </Card>
                                    <Button type="submit"></Button>
                                </Card.Group>
                            )}
                        </Formik>
                    </GridColumn>
                </Grid.Row>
            </Grid>
        </div>
    );
}

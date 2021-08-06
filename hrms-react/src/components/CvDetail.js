import React, { useState, useEffect } from "react";
import {
    Card,
    Grid,
    Image,
    Table,
    Label,
    Icon,
    Segment,
} from "semantic-ui-react";
import JobSeekerSerive from "../services/jobSeekerService";
import CurriculaVitaeService from "../services/curriculaVitaeService";
import EducationService from "../services/educationService";
import BusinessLifeService from "../services/businessLifeService";

export default function CvDetail() {
    const jobSeekerId = 6;
    const curriculaVitaeId = 4;

    const curriculaVitaeService = new CurriculaVitaeService();
    const educationService = new EducationService();
    const businessLifeService = new BusinessLifeService();

    const [jobSeeker, setJobSeeker] = useState({});
    const [curriculaVitae, setCurriculaVitae] = useState([]);
    const [cvEducations, setCvEducations] = useState([]);
    const [cvBusinessLives, setCvBusinessLives] = useState([]);
    const [cvTechnologies, setCvTechnologies] = useState([]);
    const [cvJobSeekerLanguage, setCvJobSeekerLanguage] = useState([]);
    // const [cvPicture, setCvPicture] = useState("");
    const [cvSocialMedia, setCvSocialMedia] = useState([]);

    useEffect(() => {
        const jobSeekerService = new JobSeekerSerive();
        jobSeekerService
            .getJobSeekerById(jobSeekerId)
            .then((success) => setJobSeeker(success.data.data));
        curriculaVitaeService
            .getCvByJobSeekerId(jobSeekerId)
            .then((success) => {
                setCurriculaVitae(success.data.data);
                // setCvPicture(success.data.data.pictureUrl);
                setCvSocialMedia(success.data.data.socialMedias);
                setCvTechnologies(success.data.data.technologies);
                setCvJobSeekerLanguage(success.data.data.jobSeekerLanguages);
            });
        educationService
            .getEducationSortedById(curriculaVitaeId)
            .then((success) => {
                setCvEducations(success.data.data);
            });
        businessLifeService
            .getBusinessLifeSortedById(curriculaVitaeId)
            .then((success) => {
                setCvBusinessLives(success.data.data);
            });
    }, []);

    console.log(curriculaVitae);

    return (
        <div>
            <div className="cv-detail">
                <Card.Group>
                    <Card
                        style={{
                            minWidth: "100%",
                        }}
                    >
                        <Card.Content>
                            <div
                                style={{
                                    width: "12rem",
                                    height: "12rem",
                                    float: "right",
                                    textAlign: "center",
                                }}
                            >
                                <Image
                                    style={{
                                        borderRadius: "5px",
                                    }}
                                    floated="right"
                                    size="small"
                                    z
                                    src={`${curriculaVitae.pictureUrl}`}
                                />
                            </div>
                            <div>
                                <Segment
                                    raised
                                    padded
                                    className="cv-personel-infos"
                                >
                                    <Label
                                        className="cv-personel-infos-ribbon"
                                        attached="top left"
                                        ribbon="true"
                                        color="blue"
                                    >
                                        Kişisel Bilgiler
                                    </Label>
                                    <Grid>
                                        <Grid.Column width="8">
                                            <div>{jobSeeker.firstName}</div>
                                            <div>{jobSeeker.lastName}</div>
                                            <div>{jobSeeker.email}</div>
                                            <div>{jobSeeker.birthDate}</div>
                                        </Grid.Column>
                                        <Grid.Column width="8">
                                            <div>
                                                <span
                                                    style={{
                                                        textDecoration:
                                                            "underline",
                                                    }}
                                                >
                                                    Github:
                                                </span>{" "}
                                                {
                                                    cvSocialMedia[0]
                                                        ?.githubUsername
                                                }
                                            </div>
                                            <div>
                                                <span
                                                    style={{
                                                        textDecoration:
                                                            "underline",
                                                    }}
                                                >
                                                    LinkedIn:
                                                </span>{" "}
                                                {
                                                    cvSocialMedia[0]
                                                        ?.linkedinUsername
                                                }
                                            </div>
                                        </Grid.Column>
                                    </Grid>
                                </Segment>
                            </div>
                            <div>
                                <Table
                                    celled
                                    style={{
                                        width: "100%",
                                    }}
                                >
                                    <Table.Header>
                                        <Table.Row>
                                            <Table.HeaderCell
                                                colSpan="4"
                                                textAlign="center"
                                            >
                                                Eğitim Bilgileri
                                            </Table.HeaderCell>
                                        </Table.Row>
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
                                        {cvEducations.map((education) => (
                                            <Table.Row key={education.id}>
                                                <Table.Cell>
                                                    {
                                                        education.school
                                                            ?.schoolName
                                                    }
                                                </Table.Cell>
                                                <Table.Cell>
                                                    {
                                                        education.department
                                                            ?.departmentName
                                                    }
                                                </Table.Cell>
                                                <Table.Cell>
                                                    {education.startDate}
                                                </Table.Cell>
                                                <Table.Cell>
                                                    {education.endDate === null
                                                        ? "Devam Ediyor"
                                                        : education.endDate}
                                                </Table.Cell>
                                            </Table.Row>
                                        ))}
                                    </Table.Body>
                                </Table>
                            </div>
                            <div
                                style={{
                                    marginTop: "4%",
                                }}
                            >
                                <Table
                                    celled
                                    style={{
                                        width: "100%",
                                    }}
                                >
                                    <Table.Header>
                                        <Table.Row>
                                            <Table.HeaderCell
                                                colSpan="4"
                                                textAlign="center"
                                            >
                                                Çalışma Geçmişi Bilgileri
                                            </Table.HeaderCell>
                                        </Table.Row>
                                        <Table.Row>
                                            <Table.HeaderCell>
                                                Şirket
                                            </Table.HeaderCell>
                                            <Table.HeaderCell>
                                                Çalıştığı Pozisyon
                                            </Table.HeaderCell>
                                            <Table.HeaderCell>
                                                Başlama Tarihi
                                            </Table.HeaderCell>
                                            <Table.HeaderCell>
                                                Ayrılma Tarihi
                                            </Table.HeaderCell>
                                        </Table.Row>
                                    </Table.Header>
                                    <Table.Body>
                                        {cvBusinessLives.map((businessLife) => (
                                            <Table.Row key={businessLife.id}>
                                                <Table.Cell>
                                                    {businessLife.companyName}
                                                </Table.Cell>
                                                <Table.Cell>
                                                    {businessLife.positionName}
                                                </Table.Cell>
                                                <Table.Cell>
                                                    {businessLife.startDate}
                                                </Table.Cell>
                                                <Table.Cell>
                                                    {businessLife.endDate ===
                                                    null
                                                        ? "Devam Ediyor"
                                                        : businessLife.endDate}
                                                </Table.Cell>
                                            </Table.Row>
                                        ))}
                                    </Table.Body>
                                </Table>
                            </div>
                            <div
                                celled
                                style={{
                                    marginTop: "4%",
                                }}
                            >
                                <Table celled>
                                    <Table.Header>
                                        <Table.Row>
                                            <Table.HeaderCell
                                                colSpan="4"
                                                textAlign="center"
                                            >
                                                Tecrübeli Olduğu Teknolojiler
                                            </Table.HeaderCell>
                                        </Table.Row>
                                    </Table.Header>
                                    <Table.Body>
                                        <Table.Row>
                                            {cvTechnologies.map(
                                                (technology) => (
                                                    <Label
                                                        style={{
                                                            margin: "1%",
                                                            fontSize: "1.2rem",
                                                        }}
                                                        key={technology.id}
                                                    >
                                                        {
                                                            technology.programmingLanguage
                                                        }
                                                    </Label>
                                                )
                                            )}
                                        </Table.Row>
                                    </Table.Body>
                                </Table>
                            </div>
                            <div
                                celled
                                style={{
                                    marginTop: "4%",
                                }}
                            >
                                <Table celled>
                                    <Table.Header>
                                        <Table.Row>
                                            <Table.HeaderCell
                                                colSpan="5"
                                                textAlign="center"
                                            >
                                                Konuştuğu Diller ve Dereceleri
                                            </Table.HeaderCell>
                                        </Table.Row>
                                    </Table.Header>
                                    <Table.Body>
                                        <Table.Row>
                                            {cvJobSeekerLanguage.map(
                                                (jobSeekerLanguage) => (
                                                    <Label
                                                        style={{
                                                            margin: "1%",
                                                            fontSize: "1.2rem",
                                                        }}
                                                        key={
                                                            jobSeekerLanguage.id
                                                        }
                                                    >
                                                        {
                                                            jobSeekerLanguage
                                                                .language
                                                                ?.languageName
                                                        }
                                                        <Icon
                                                            name="star"
                                                            color={
                                                                jobSeekerLanguage.languageDegree >=
                                                                1
                                                                    ? "yellow"
                                                                    : ""
                                                            }
                                                        ></Icon>
                                                        <Icon
                                                            name="star"
                                                            color={
                                                                jobSeekerLanguage.languageDegree >=
                                                                2
                                                                    ? "yellow"
                                                                    : ""
                                                            }
                                                        ></Icon>
                                                        <Icon
                                                            readOnly
                                                            name="star"
                                                            color={
                                                                jobSeekerLanguage.languageDegree >=
                                                                3
                                                                    ? "yellow"
                                                                    : ""
                                                            }
                                                        ></Icon>
                                                        <Icon
                                                            name="star"
                                                            color={
                                                                jobSeekerLanguage.languageDegree >=
                                                                4
                                                                    ? "yellow"
                                                                    : ""
                                                            }
                                                        ></Icon>
                                                        <Icon
                                                            name="star"
                                                            color={
                                                                jobSeekerLanguage.languageDegree ===
                                                                5
                                                                    ? "yellow"
                                                                    : ""
                                                            }
                                                        ></Icon>
                                                    </Label>
                                                )
                                            )}
                                        </Table.Row>
                                    </Table.Body>
                                </Table>
                            </div>
                            <div
                                style={{
                                    marginTop: "4%",
                                }}
                            >
                                <Label
                                    style={{
                                        textAlign: "center",
                                        marginLeft: "1.6%",
                                    }}
                                    size="large"
                                    color="blue"
                                    pointing="below"
                                >
                                    Kişisel Açıklama
                                </Label>
                                <textarea
                                    readOnly="true"
                                    style={{
                                        resize: "none",
                                        minWidth: "100%",
                                        fontFamily: "Andale Mono, monospace",
                                        letterSpacing: ".5px",
                                        wordSpacing: ".7px",
                                        fontSize: "large",
                                        lineHeight: "2rem",
                                    }}
                                    rows={10}
                                    maxLength={1000}
                                    placeholder="1000 karakter ile sınırlıdır."
                                    value={curriculaVitae.coverLetter}
                                ></textarea>
                            </div>
                        </Card.Content>
                    </Card>
                </Card.Group>
            </div>
        </div>
    );
}

import React, { useState, useEffect } from "react";
import {
    Button,
    Card,
    Grid,
    Image,
    Input,
    Table,
    Label,
    Icon,
    Segment,
} from "semantic-ui-react";
import { ToastContainer, toast } from "react-toastify";
import Select from "react-select";
import FormData from "form-data";
import JobSeekerSerive from "../services/jobSeekerService";
import SchoolService from "../services/schoolService";
import DepartmentService from "../services/departmentService";
import CurriculaVitaeService from "../services/curriculaVitaeService";
import EducationService from "../services/educationService";
import BusinessLifeService from "../services/businessLifeService";
import TechnologyService from "../services/technologieService";
import JobSeekerLanguageService from "../services/jobSeekerLanguageService";
import LanguageService from "../services/languageService";

export default function CreateCv() {
    const jobSeekerId = 6;
    const curriculaVitaeId = 4;
    let picture;

    const educationObject = {
        id: 0,
        curriculaVitaeId: 4,
        schoolId: "",
        departmentId: "",
        startDate: null,
        endDate: null,
    };
    const businessLifeObject = {
        id: 0,
        curriculaVitaeId: 4,
        companyName: "",
        positionName: "",
        startDate: null,
        endDate: null,
    };
    const technologyObject = {
        id: 0,
        curriculaVitaeId: 4,
        programmingLanguage: "",
    };
    const jobSeekerLanguageObject = {
        id: 0,
        curriculaVitaeId: 4,
        languageDegree: null,
        languageId: "",
    };
    const languageDegrees = [
        { key: 1, label: "1", value: 1 },
        { key: 2, label: "2", value: 2 },
        { key: 3, label: "3", value: 3 },
        { key: 4, label: "4", value: 4 },
        { key: 5, label: "5", value: 5 },
    ];
    const coverLetterObject = {
        curriculaVitaeId: 4,
        coverLetter: "",
    };

    const curriculaVitaeService = new CurriculaVitaeService();
    const educationService = new EducationService();
    const businessLifeService = new BusinessLifeService();
    const technologyService = new TechnologyService();
    const jobSeekerLanguageService = new JobSeekerLanguageService();

    const [jobSeeker, setJobSeeker] = useState({});
    const [schools, setSchools] = useState([]);
    const [departments, setDepartments] = useState([]);
    const [languages, setLanguages] = useState([]);
    const [curriculaVitae, setCurriculaVitae] = useState([]);
    const [cvEducations, setCvEducations] = useState([]);
    const [cvBusinessLives, setCvBusinessLives] = useState([]);
    const [cvTechnologies, setCvTechnologies] = useState([]);
    const [cvJobSeekerLanguage, setCvJobSeekerLanguage] = useState([]);
    const [cvPicture, setCvPicture] = useState("");
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
                setCvPicture(success.data.data.pictureUrl);
                setCvSocialMedia(success.data.data.socialMedias);
                setCvTechnologies(success.data.data.technologies);
                setCvJobSeekerLanguage(success.data.data.jobSeekerLanguages);
            });
        const schoolService = new SchoolService();
        schoolService
            .getSchools()
            .then((success) => setSchools(success.data.data));
        const departmentService = new DepartmentService();
        departmentService
            .getDepartments()
            .then((success) => setDepartments(success.data.data));
        const languageService = new LanguageService();
        languageService
            .getLanguages()
            .then((success) => setLanguages(success.data.data));
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

    console.log(cvEducations);

    const schoolHandler = (e) => {
        educationObject.schoolId = e.value;
    };

    const departmentHandler = (e) => {
        educationObject.departmentId = e.value;
    };

    const eduStartDateHandler = (e) => {
        educationObject.startDate = e;
    };

    const eduEndDateHandler = (e) => {
        educationObject.endDate = e;
    };

    const getCvEducations = () => {
        educationService
            .getEducationSortedById(curriculaVitaeId)
            .then((success) => {
                setCvEducations(success.data.data);
            });
    };

    const postEducation = () => {
        if (
            educationObject.departmentId < 1 ||
            educationObject.schoolId < 1 ||
            educationObject.startDate === null
        ) {
            toast.error("Sadece bitirme tarihi boş bırakılabilir!");
        } else {
            educationService.addEducation(educationObject).then((success) => {
                toast.success(success);
                getCvEducations();
            });
        }
    };

    const deleteEducation = (id) => {
        educationService.deleteEducationById(id).then((success) => {
            toast.success(success.data.message);
            getCvEducations();
        });
    };

    const companyNameHandler = (e) => {
        businessLifeObject.companyName = e;
    };

    const positionNameHandler = (e) => {
        businessLifeObject.positionName = e;
    };

    const blStartDateHandler = (e) => {
        businessLifeObject.startDate = e;
    };

    const blEndDateHandler = (e) => {
        businessLifeObject.endDate = e;
    };

    const getCvBusinessLives = () => {
        businessLifeService
            .getBusinessLifeSortedById(curriculaVitaeId)
            .then((success) => {
                setCvBusinessLives(success.data.data);
            });
    };

    const postBusinessLife = () => {
        if (
            businessLifeObject.companyName.length < 1 ||
            businessLifeObject.positionName.length < 1 ||
            businessLifeObject.startDate === null
        ) {
            toast.error("Sadece ayrılma tarihi boş bırakılabilir");
            return;
        } else {
            businessLifeService
                .addBusinessLife(businessLifeObject)
                .then((success) => {
                    toast.success(success);
                    getCvBusinessLives();
                });
        }
    };

    const deleteBusinessLife = (id) => {
        businessLifeService.deleteBusinessLife(id).then((success) => {
            toast.success(success.data.message);
            getCvBusinessLives();
        });
    };

    const programmingLanguageNameHandler = (e) => {
        technologyObject.programmingLanguage = e;
    };

    const postTechnology = () => {
        if (technologyObject.programmingLanguage.length > 20) {
            toast.error("Teknoloji adı 20 karakterden uzun olmamalıdır!");
        } else {
            technologyService
                .addTechnologie(technologyObject)
                .then((success) => {
                    toast.success(success);
                    curriculaVitaeService
                        .getCvByJobSeekerId(jobSeekerId)
                        .then((res) => {
                            setCvTechnologies(res.data.data.technologies);
                        });
                });
        }
    };

    const deleteTechnology = (id) => {
        technologyService.deleteTechnology(id).then((success) => {
            toast.success(success.data.message);
            curriculaVitaeService
                .getCvByJobSeekerId(jobSeekerId)
                .then((res) => {
                    setCvTechnologies(res.data.data.technologies);
                });
        });
    };

    const jobSeekerLanguageHandler = (e) => {
        jobSeekerLanguageObject.languageId = e.value;
    };

    const jobSeekerLanguageDegreeHandler = (e) => {
        jobSeekerLanguageObject.languageDegree = e.value;
    };

    const postJobSeekerLanguage = () => {
        jobSeekerLanguageService
            .addJobSeekerLanguage(jobSeekerLanguageObject)
            .then((success) => {
                toast.success(success);
                curriculaVitaeService
                    .getCvByJobSeekerId(jobSeekerId)
                    .then((res) => {
                        setCvJobSeekerLanguage(
                            res.data.data.jobSeekerLanguages
                        );
                    });
            });
    };

    const deleteJobSeekerLanguage = (id) => {
        jobSeekerLanguageService.deleteJobSeekerLanguage(id).then((success) => {
            toast.success(success.data.message);
            curriculaVitaeService
                .getCvByJobSeekerId(jobSeekerId)
                .then((res) => {
                    setCvJobSeekerLanguage(res.data.data.jobSeekerLanguages);
                });
        });
    };

    const coverLetterHandler = (e) => {
        coverLetterObject.coverLetter = e;
    };

    const updateCoverLetter = () => {
        const willPostJobSeekerId = coverLetterObject.curriculaVitaeId;
        const willPostCoverLetter = coverLetterObject.coverLetter;
        curriculaVitaeService
            .updateCvCoverLetter(willPostJobSeekerId, willPostCoverLetter)
            .then((success) => {
                toast.success(success);
            })
            .catch(() => {
                toast.error("Hata oluştu! Tekrar deneyin.");
            });
    };

    const handleCvPicture = (event) => {
        picture = event.target.files[0];
        let formData = new FormData();
        formData.append("file", picture);
        toast.warning("İstek gönderildi.");
        curriculaVitaeService
            .addPictureToCv(formData, curriculaVitaeId)
            .then((success) => {
                toast.success(success);
                curriculaVitaeService
                    .getCvByJobSeekerId(jobSeekerId)
                    .then((success) => {
                        setCvPicture(success.data.data.pictureUrl);
                    });
            })
            .catch((err) => {
                toast.error(err);
            });
    };

    console.log(curriculaVitae);
    console.log(cvSocialMedia);

    return (
        <div>
            <ToastContainer />
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
                                    src={`${cvPicture}`}
                                />
                                <input
                                    className="pictureFileInput"
                                    id="pictureFile"
                                    accept="image/*"
                                    type="file"
                                    onChange={handleCvPicture}
                                />
                                <label
                                    for="pictureFile"
                                    className="pictureFileLabel"
                                >
                                    Fotoğraf Seç
                                    <Icon
                                        name="picture"
                                        style={{
                                            marginLeft: "3%",
                                        }}
                                    ></Icon>
                                </label>
                            </div>
                            <div
                                style={{
                                    display: "inline",
                                }}
                            >
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
                                                colSpan="5"
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
                                            <Table.HeaderCell>
                                                Ekle/Sil
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
                                                        (school) => ({
                                                            label: school.schoolName,
                                                            value: school.id,
                                                            key: school.id,
                                                        })
                                                    )}
                                                    onChange={schoolHandler}
                                                />
                                            </Table.Cell>
                                            <Table.Cell>
                                                <Select
                                                    className="cv-select"
                                                    placeholder="Bölüm seç"
                                                    options={departments.map(
                                                        (department) => ({
                                                            label: department.departmentName,
                                                            value: department.id,
                                                            key: department.id,
                                                        })
                                                    )}
                                                    onChange={departmentHandler}
                                                />
                                            </Table.Cell>
                                            <Table.Cell>
                                                <Input
                                                    type="date"
                                                    id="startDate"
                                                    onChange={(event) =>
                                                        eduStartDateHandler(
                                                            event.target.value
                                                        )
                                                    }
                                                />
                                            </Table.Cell>
                                            <Table.Cell>
                                                <Input
                                                    type="date"
                                                    id="endDate"
                                                    onChange={(event) =>
                                                        eduEndDateHandler(
                                                            event.target.value
                                                        )
                                                    }
                                                />
                                            </Table.Cell>
                                            <Table.Cell
                                                style={{
                                                    color: "#4cd137",
                                                    fontWeight: "bolder",
                                                    marginLeft: "15%",
                                                    cursor: "pointer",
                                                    textAlign: "center",
                                                    letterSpacing: "1px",
                                                }}
                                                onClick={postEducation}
                                            >
                                                Ekle
                                            </Table.Cell>
                                        </Table.Row>
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
                                                <Table.Cell
                                                    style={{
                                                        color: "#eb2f06",
                                                        fontWeight: "bolder",
                                                        marginLeft: "15%",
                                                        cursor: "pointer",
                                                        textAlign: "center",
                                                        letterSpacing: "1px",
                                                    }}
                                                    onClick={(e) =>
                                                        deleteEducation(
                                                            education.id
                                                        )
                                                    }
                                                >
                                                    Sil
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
                                                colSpan="5"
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
                                            <Table.HeaderCell>
                                                Ekle/Sil
                                            </Table.HeaderCell>
                                        </Table.Row>
                                    </Table.Header>
                                    <Table.Body>
                                        <Table.Row>
                                            <Table.Cell>
                                                <input
                                                    type="text"
                                                    placeholder="Şirket adı"
                                                    id="companyName"
                                                    onChange={(event) =>
                                                        companyNameHandler(
                                                            event.target.value
                                                        )
                                                    }
                                                ></input>
                                            </Table.Cell>
                                            <Table.Cell>
                                                <input
                                                    type="text"
                                                    placeholder="İş pozisyonu"
                                                    id="positionName"
                                                    onChange={(event) =>
                                                        positionNameHandler(
                                                            event.target.value
                                                        )
                                                    }
                                                ></input>
                                            </Table.Cell>
                                            <Table.Cell>
                                                <Input
                                                    type="date"
                                                    id="startDate"
                                                    onChange={(event) =>
                                                        blStartDateHandler(
                                                            event.target.value
                                                        )
                                                    }
                                                />
                                            </Table.Cell>
                                            <Table.Cell>
                                                <Input
                                                    type="date"
                                                    id="endDate"
                                                    onChange={(event) =>
                                                        blEndDateHandler(
                                                            event.target.value
                                                        )
                                                    }
                                                />
                                            </Table.Cell>
                                            <Table.Cell
                                                style={{
                                                    color: "#4cd137",
                                                    fontWeight: "bolder",
                                                    marginLeft: "15%",
                                                    cursor: "pointer",
                                                    textAlign: "center",
                                                    letterSpacing: "1px",
                                                }}
                                                onClick={postBusinessLife}
                                            >
                                                Ekle
                                            </Table.Cell>
                                        </Table.Row>
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
                                                <Table.Cell
                                                    style={{
                                                        color: "#eb2f06",
                                                        fontWeight: "bolder",
                                                        marginLeft: "15%",
                                                        cursor: "pointer",
                                                        textAlign: "center",
                                                        letterSpacing: "1px",
                                                    }}
                                                    onClick={(e) =>
                                                        deleteBusinessLife(
                                                            businessLife.id
                                                        )
                                                    }
                                                >
                                                    Sil
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
                                        <Table.Row>
                                            <Table.HeaderCell
                                                colSpan="5"
                                                textAlign="center"
                                            >
                                                <input
                                                    maxLength="20"
                                                    type="text"
                                                    placeholder="Teknoloji..."
                                                    id="programmingLanguage"
                                                    onChange={(event) =>
                                                        programmingLanguageNameHandler(
                                                            event.target.value
                                                        )
                                                    }
                                                ></input>
                                                <Button
                                                    style={{
                                                        marginLeft: "2%",
                                                    }}
                                                    color="green"
                                                    size="mini"
                                                    onClick={postTechnology}
                                                >
                                                    Ekle
                                                </Button>
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
                                                        <Icon
                                                            name="delete"
                                                            color="red"
                                                            onClick={(e) =>
                                                                deleteTechnology(
                                                                    technology.id
                                                                )
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
                                        <Table.Row>
                                            <Table.HeaderCell
                                                colSpan="5"
                                                textAlign="center"
                                            >
                                                <Select
                                                    className="cv-select"
                                                    placeholder="Dil seç"
                                                    options={languages.map(
                                                        (language) => ({
                                                            label: language.languageName,
                                                            value: language.id,
                                                            key: language.id,
                                                        })
                                                    )}
                                                    onChange={
                                                        jobSeekerLanguageHandler
                                                    }
                                                />
                                                <Select
                                                    className="cv-select"
                                                    placeholder="Dil derecesi seç"
                                                    options={languageDegrees.map(
                                                        (languageDegree) => ({
                                                            label: languageDegree.label,
                                                            value: languageDegree.value,
                                                            key: languageDegree.key,
                                                        })
                                                    )}
                                                    onChange={
                                                        jobSeekerLanguageDegreeHandler
                                                    }
                                                />
                                                <Button
                                                    style={{
                                                        marginTop: "1%",
                                                    }}
                                                    color="green"
                                                    size="mini"
                                                    onClick={
                                                        postJobSeekerLanguage
                                                    }
                                                >
                                                    Ekle
                                                </Button>
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
                                                                jobSeekerLanguage.languageDegree ==
                                                                5
                                                                    ? "yellow"
                                                                    : ""
                                                            }
                                                        ></Icon>
                                                        <Icon
                                                            name="delete"
                                                            color="red"
                                                            onClick={(e) =>
                                                                deleteJobSeekerLanguage(
                                                                    jobSeekerLanguage.id
                                                                )
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
                                    onChange={(event) =>
                                        coverLetterHandler(event.target.value)
                                    }
                                ></textarea>
                            </div>
                            <Button
                                type="submit"
                                floated="right"
                                color="green"
                                onClick={updateCoverLetter}
                            >
                                Açıklamayı Güncelle
                            </Button>
                        </Card.Content>
                    </Card>
                </Card.Group>
            </div>
        </div>
    );
}

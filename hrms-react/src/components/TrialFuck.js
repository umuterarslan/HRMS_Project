import React from "react";

export default function TrialFuck({ jobAdverts }) {
    return (
        <div>
            <div>
                {jobAdverts.map((jobAdvert) => {
                    return (
                        <div key={jobAdvert.id}>
                            <div>{jobAdvert.jobPosition.jobTitle}</div>
                            <div>{jobAdvert.employer.companyName}</div>
                            <div>{jobAdvert.description}</div>
                        </div>
                    );
                })}
            </div>
        </div>
    );
}

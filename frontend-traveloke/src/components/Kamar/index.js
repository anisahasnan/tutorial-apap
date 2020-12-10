import React from "react";
import classes from "./styles.module.css";

const Kamar = (props) => {
    const { namaKamar, kapasitasKamar } = props;
    return (
        <div className={classes.kamar}>
            <p>{`Nama Kamar: ${namaKamar}`}</p>
            <p>{`Kapasitas Kamar: ${kapasitasKamar}`}</p>
        </div>
    );
};

export default Kamar;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alext
 */
public class VotosModelo {
    private int votoId;
    private int votoCandidateId;
    private String votoCedula;

    public VotosModelo() {
    }

    public VotosModelo(int candidateId, String cedulaUsuario) {
        this.votoCandidateId = candidateId;
        this.votoCedula = cedulaUsuario;
    }

    public int getVotoId() {
        return votoId;
    }

    public void setVotoId(int votoId) {
        this.votoId = votoId;
    }

    public int getVotoCandidateId() {
        return votoCandidateId;
    }

    public void setVotoCandidateId(int votoCandidateId) {
        this.votoCandidateId = votoCandidateId;
    }

    public String getVotoCedula() {
        return votoCedula;
    }

    public void setVotoCedula(String votoCedula) {
        this.votoCedula = votoCedula;
    }

    @Override
    public String toString() {
        return "VotoModelo{" +
                "votoId=" + votoId +
                ", votoCandidateId=" + votoCandidateId +
                ", votoCedula='" + votoCedula + '\'' +
                '}';
    }

    public void setVoto_candidate_id(int candidatoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


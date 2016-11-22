package com.unb.matriculeme.domain;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.unb.matriculeme.dao.Curriculo;
import com.unb.matriculeme.dao.Curso;
import com.unb.matriculeme.dao.Disciplina;
import com.unb.matriculeme.helpers.ClientUtils;
import com.unb.matriculeme.helpers.PersistenceHelper;
import com.unb.matriculeme.messages.AllRightMessage;
import com.unb.matriculeme.messages.BaseMessage;
import com.unb.matriculeme.messages.NotFoundMessage;

@Path("/curriculos")
public class CurriculumController  {

	@Path("/setCurriculo")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sayPlainTextHello(Curriculo course) throws Exception {
        PersistenceHelper.persist(course);
        return ClientUtils.sendMessage(new AllRightMessage("The curriculo was inserted on the system successfully."));
    }
	
    @Path("/getCurriculo/disciplina={nomeDisciplina}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertFeetToInch(@PathParam("nomeDisciplina") String nomeDisciplina) {
        Disciplina disciplina = (Disciplina) PersistenceHelper.queryCustom("Disciplina", "nome", nomeDisciplina, true);
        List courses = PersistenceHelper.queryCustom("Disciplina", "nome", nomeDisciplina, true);
        return courses.size() > 0 ? ClientUtils.sendResponse(courses) :
                ClientUtils.sendMessage(new NotFoundMessage("The curriculo wasn't found on the system."));
    }

    @Path("/getCurso/nome={nome}&codigo={codigo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response example(@PathParam("nome") String nome, @PathParam("codigo") int codigo) {
        List courses = PersistenceHelper.queryCustom("Curso", "nome", nome, "codigo", String.valueOf(codigo));
        return courses.size() > 0 ? ClientUtils.sendResponse(courses) :
                ClientUtils.sendMessage(new NotFoundMessage("The Course wasn't found on the system."));
    }
    
	@Path("/alterCurso/nome={nome}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterCurso(@PathParam("nome") String nome, Curso course) throws Exception {
        List courses = PersistenceHelper.queryCustom("Curso", "nome", nome, true);

        if (courses.size() > 0) {
            PersistenceHelper.update((Curso) courses.get(0), course);
        }

        return ClientUtils.sendMessage(courses.size() > 0 ? new BaseMessage(200, "Course changed successfully.") :
                new NotFoundMessage("This course wasn't found on our system."));
	}
}

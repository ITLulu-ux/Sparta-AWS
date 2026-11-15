package spartaaws.spartaaws.member;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponseDto createMember(
            @Valid @RequestBody MemberRequestDto requestDto) {

        return memberService.createMember(requestDto);
    }

    @GetMapping("/{id}")
    public MemberResponseDto getMember(@PathVariable Long id) {

        return memberService.getMember(id);
    }
}

